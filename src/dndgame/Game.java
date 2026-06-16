/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class manages the main game flow.
 * It connects the hero, room, combat manager, and shop.
 */
package dndgame;

public class Game {

    private Hero hero;
    private Room currentRoom;
    private CombatManager combatManager;
    private Shop shop;
    private int roomNumber;
    private boolean bossUnlocked;
    private boolean gameWon;
    private boolean gameOver;
    private GameRules gameRules;
    private String lastTrapMessage;

    public Game(Hero hero) {
        this.hero = hero;
        this.combatManager = new CombatManager();
        this.shop = new Shop();
        this.roomNumber = 1;
        this.currentRoom = createRoom(roomNumber);
        this.bossUnlocked = false;
        this.gameWon = false;
        this.gameOver = false;
        this.lastTrapMessage = "";
        this.gameRules = new GameRules();
    }

    public Hero getHero() {
        return hero;
    }
    
    public CombatManager getCombatManager() {
        return combatManager;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Shop getShop() {
        return shop;
    }

    public void heroAttack() {
        if (currentRoom.hasMonster()) {
            combatManager.heroAttack(hero, currentRoom.getMonster(),gameRules.isDoubleDiceEnabled());

            if (!currentRoom.getMonster().isAlive()) {

                if (currentRoom.getMonster().getName().equals("Ancient Shadow Dragon")) {
                    gameWon = true;
                    currentRoom.clearRoom();
                    System.out.println("Victory! You defeated the Ancient Shadow Dragon.");
                    return;
                }

                currentRoom.clearRoom();

                int goldReward = 20 + (roomNumber * 10);
                int experienceReward = 15 + (roomNumber * 8);

                hero.addGold(goldReward);
                hero.gainExperience(experienceReward);

                System.out.println("Room cleared!");
                System.out.println("You gained "
                        + goldReward
                        + " gold and "
                        + experienceReward
                        + " experience.");
            }
        } 
        else {
            System.out.println("There is no monster to attack.");
        }
    }
    
    public void heroSpecialAttack() {

        if (!currentRoom.hasMonster()) {

            System.out.println(
                    "No monster available."
            );

            return;
        }

        if (!currentRoom.getMonster().isAlive()) {

            System.out.println(
                    "Monster already defeated."
            );

            return;
        }

        combatManager.heroSpecialAttack(
                hero,
                currentRoom.getMonster()
        );
    }

   public void monsterAttack() {

        if (!currentRoom.hasMonster()) {
            System.out.println("No monster can attack you.");
            return;
        }

        combatManager.monsterAttack(
                currentRoom.getMonster(),
                hero,
                gameRules.isAdaptiveAIEnabled()
        );

        hero.updateStatusEffects();
        
        if (!hero.isAlive()) {

            if (gameRules.isPermadeathEnabled()) {

                gameOver = true;

                System.out.println(
                        "Permadeath enabled. Game Over."
                );
            }
        }
    }

    public void goToNextRoom() {
        
        if (!currentRoom.isCleared()) {
            System.out.println("You must clear the current room first.");
            return;
        }

        roomNumber++;
        currentRoom = createRoom(roomNumber);
        
        lastTrapMessage = "";
        
        if (gameRules.isTrapsEnabled()) {
            
            handleTrap();
            
        }
        
        if (roomNumber >= 5) {

            bossUnlocked = true;

            System.out.println(
                    "The boss chamber is now unlocked."
            );
        }
        System.out.println("You entered room " + roomNumber + ".");
        System.out.println(currentRoom.getDescription());
    }
    
    public boolean isBossUnlocked() {
        return bossUnlocked;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void startBossFight() {
        if (!bossUnlocked) {
            System.out.println("Boss room is locked. Reach room 5 first.");
            return;
        }

        if (currentRoom.hasMonster()) {
            System.out.println("Defeat the current monster first.");
            return;
        }

        Monster boss = MonsterFactory.createBoss(hero);
        

        currentRoom = new Room(
                999,
                "The final chamber burns with shadow fire.",
                boss
        );

        System.out.println("The Ancient Shadow Dragon appears!");
    }

    private Room createRoom(int number) {
        
        Monster monster = MonsterFactory.createMonster(number, hero);

        return new Room(
                number,
                "A shadowy dungeon room filled with danger.",
                monster
        );
    }
    
    public void usePotion(Potion potion) {
        if (potion == null) {
            System.out.println("No potion selected.");
            return;
        }

        String beforeEffects = hero.getActiveEffectsText();
        int beforeHP = hero.getCurrentHealth();

        if (potion instanceof HealingPotion) {
            ((HealingPotion) potion).use(hero);
        } else {
            potion.use(hero);
        }

        String afterEffects = hero.getActiveEffectsText();
        int afterHP = hero.getCurrentHealth();

        if (beforeEffects.equals(afterEffects) && beforeHP == afterHP) {
            System.out.println("Potion had no effect and was not consumed.");
            return;
        }

        hero.getInventory().removeItem(potion);
        combatManager.recordPotionUse();
    }
    
    private void handleTrap() {

        Dice dice = new Dice();
        
        lastTrapMessage = "";

        int trapRoll = dice.roll(20);

        int trapDifficulty = 10 + roomNumber / 3;

        if (trapRoll >= trapDifficulty) {

            lastTrapMessage =
                    "Trap avoided! D20 roll: "
                    + trapRoll
                    + ".";

            System.out.println(lastTrapMessage);

        } 
        else {

            int trapDamage =
                    dice.roll(6)
                    + roomNumber;

            hero.takeDamage(trapDamage);

            lastTrapMessage =
                    "Trap triggered! You took "
                    + trapDamage
                    + " damage.";

            System.out.println(lastTrapMessage);
        }
    }
    
    
    public boolean isGameOver() {
        
        return gameOver;
    }
    
    public String getLastTrapMessage() {
        
        return lastTrapMessage;
    }
    
    public GameRules getGameRules() {
        
        return gameRules;
    }
    
}