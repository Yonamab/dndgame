/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class manages the main game flow.
 * It connects the hero, room, combat manager, shop, rules, and messages.
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

    private String lastGameMessage;

    public Game(Hero hero) {
        this.hero = hero;
        this.combatManager = new CombatManager();
        this.shop = new Shop();
        this.roomNumber = 1;
        this.currentRoom = createRoom(roomNumber);
        this.bossUnlocked = false;
        this.gameWon = false;
        this.gameOver = false;
        this.gameRules = new GameRules();
        this.lastGameMessage = "";
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

    public GameRules getGameRules() {
        return gameRules;
    }

    public boolean isBossUnlocked() {
        return bossUnlocked;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getLastGameMessage() {
        return lastGameMessage;
    }

    private void clearMessage() {
        lastGameMessage = "";
    }

    private void addMessage(String message) {
        lastGameMessage += message + "\n";
        System.out.println(message);
    }

    public void heroAttack() {
        
        clearMessage();

        if (!currentRoom.hasMonster()) {
            addMessage("There is no monster to attack.");
            return;
        }

        Monster monster = currentRoom.getMonster();

        if (!monster.isAlive()) {
            
            addMessage("Monster already defeated.");
            return;
            
        }

        addMessage(hero.getName() + " attacks " + monster.getName() + ".");

        combatManager.heroAttack(
                hero,
                monster,
                gameRules.isDoubleDiceEnabled()
        );

        addMessage("D20 Roll: " + combatManager.getLastD20Roll());
        addMessage("Damage dealt: " + combatManager.getLastDamageRoll());

        if (gameRules.isDoubleDiceEnabled()) {
            addMessage("Double Dice Damage rule is active.");
        }

        if (!monster.isAlive()) {

            if (monster.getMonsterType() == MonsterType.ANCIENT_SHADOW_DRAGON) {
                gameWon = true;
                currentRoom.clearRoom();
                addMessage("Victory! You defeated the Ancient Shadow Dragon.");
                return;
            }

            currentRoom.clearRoom();

            int goldReward = 15 + (roomNumber * 7);
            int experienceReward = 15 + (roomNumber * 8);

            hero.addGold(goldReward);
            hero.gainExperience(experienceReward);

            addMessage(monster.getName() + " was defeated.");
            addMessage("Room cleared.");
            addMessage("You gained " + goldReward + " gold.");
            addMessage("You gained " + experienceReward + " experience.");
        }
    }

    public void heroSpecialAttack() {
        clearMessage();

        if (!currentRoom.hasMonster()) {
            addMessage("No monster available.");
            return;
        }

        Monster monster = currentRoom.getMonster();

        if (!monster.isAlive()) {
            addMessage("Monster already defeated.");
            return;
        }

        addMessage(hero.getName()
                + " used "
                + hero.getSpecialAttackName()
                + " on "
                + monster.getName()
                + ".");

        combatManager.heroSpecialAttack(hero, monster);

        addMessage("D20 Roll: " + combatManager.getLastD20Roll());
        addMessage("Special damage dealt: " + combatManager.getLastDamageRoll());

        if (gameRules.isDoubleDiceEnabled()) {
            addMessage("Double Dice Damage rule is active.");
        }

        if (!monster.isAlive()) {

            if (monster.getMonsterType() == MonsterType.ANCIENT_SHADOW_DRAGON) {
                gameWon = true;
                currentRoom.clearRoom();
                addMessage("Victory! You defeated the Ancient Shadow Dragon.");
                return;
            }

            currentRoom.clearRoom();

            int goldReward = 15 + (roomNumber * 7);
            int experienceReward = 15 + (roomNumber * 8);

            hero.addGold(goldReward);
            hero.gainExperience(experienceReward);

            addMessage(monster.getName() + " was defeated.");
            addMessage("Room cleared.");
            addMessage("You gained " + goldReward + " gold.");
            addMessage("You gained " + experienceReward + " experience.");
        }
    }

    public void monsterAttack() {
        clearMessage();

        if (!currentRoom.hasMonster()) {
            addMessage("No monster can attack you.");
            return;
        }

        Monster monster = currentRoom.getMonster();

        if (!monster.isAlive()) {
            addMessage("The monster is defeated and cannot attack.");
            return;
        }

        addMessage(monster.getName() + " prepares to attack.");

        combatManager.monsterAttack(
                currentRoom.getMonster(),
                hero,
                gameRules.isAdaptiveAIEnabled(),
                gameRules.isBossRageModeEnabled(),
                gameRules.isDoubleDiceEnabled()
        );

        addMessage("Enemy D20 Roll: " + combatManager.getLastD20Roll());
        addMessage("Enemy damage: " + combatManager.getLastDamageRoll());

      

        if (gameRules.isBossRageModeEnabled()
                && monster.getMonsterType() == MonsterType.ANCIENT_SHADOW_DRAGON
                && monster.getCurrentHealth() < monster.getMaxHealth() / 2) {

            addMessage("Boss Rage Mode is active. The dragon is enraged.");
        }

        hero.updateStatusEffects();

        handleHeroDeath();
    }

    public void goToNextRoom() {
        clearMessage();

        if (!currentRoom.isCleared()) {
            addMessage("You must clear the current room first.");
            return;
        }

        roomNumber++;
        currentRoom = createRoom(roomNumber);

        addMessage("You entered room " + roomNumber + ".");
        addMessage(currentRoom.getDescription());

        if (gameRules.isTrapsEnabled()) {
            handleTrap();
        }

        if (roomNumber >= 6) {
            bossUnlocked = true;
            addMessage("The boss chamber is now unlocked.");
        }

        if (currentRoom.hasMonster()) {
            addMessage("A " + currentRoom.getMonster().getName() + " appears.");
        }
    }

    public void startBossFight() {
        clearMessage();

        if (!bossUnlocked) {
            addMessage("Boss room is locked. Reach room 6 first.");
            return;
        }

        if (currentRoom.hasMonster() && currentRoom.getMonster().isAlive()) {
            addMessage("Defeat the current monster first.");
            return;
        }

        Monster boss = MonsterFactory.createBoss(hero);

        currentRoom = new Room(
                999,
                "The final chamber burns with shadow fire.",
                boss
        );

        addMessage("The Ancient Shadow Dragon appears.");
        addMessage("Final battle begins.");
    }

    public void usePotion(Potion potion) {
        clearMessage();

        if (potion == null) {
            addMessage("No potion selected.");
            return;
        }

        String beforeEffects = hero.getActiveEffectsText();
        int beforeHP = hero.getCurrentHealth();

        addMessage(hero.getName() + " used " + potion.getName() + ".");

        potion.use(hero);

        String afterEffects = hero.getActiveEffectsText();
        int afterHP = hero.getCurrentHealth();

        if (beforeEffects.equals(afterEffects) && beforeHP == afterHP) {
            addMessage(potion.getName() + " had no effect and was not consumed.");
            return;
        }

        if (beforeHP != afterHP) {
            addMessage("HP changed: " + beforeHP + " -> " + afterHP + ".");
        }

        if (!beforeEffects.equals(afterEffects)) {
            addMessage("Active effects: " + afterEffects);
        }

        hero.getInventory().removeItem(potion);
        combatManager.recordPotionUse();
    }

    private void handleTrap() {
        Dice dice = new Dice();

        int trapRoll = dice.roll(20);
        int trapDifficulty = 10 + roomNumber / 3;

        if (trapRoll >= trapDifficulty) {

            addMessage("Trap avoided! D20 roll: " + trapRoll + ".");

        } else {

            int trapDamage = dice.roll(6) + roomNumber;

            hero.takeDamage(trapDamage);

            addMessage("Trap triggered! D20 roll: " + trapRoll + ".");
            addMessage("You took " + trapDamage + " trap damage.");

            handleHeroDeath();
        }
    }
    
    public void heroDefend() {
        
        clearMessage();

        hero.defend();

        combatManager.recordDefendUse();

        addMessage(
                hero.getName()
                + " takes a defensive stance. Next damage will be reduced by "
                + hero.getDefenseReductionPercent()
                + "%."
        );
    }
    
    private void handleHeroDeath() {

        if (!hero.isAlive()) {

            if (gameRules.isPermadeathEnabled()) {

                gameOver = true;

                addMessage(
                        "Permadeath enabled. Game Over."
                );

            } else {

                hero.refillHealth();

                addMessage(
                        "Permadeath is OFF. "
                        + hero.getName()
                        + " revives in the same room with full health."
                );
            }
        }
    }

    private Room createRoom(int number) {
        Monster monster = MonsterFactory.createMonster(number, hero);

        return new Room(
                number,
                "A shadowy dungeon room filled with danger.",
                monster
        );
    }
}