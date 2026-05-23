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
    private HealingRule healingRule;
    private RewardRule rewardRule;
    private BossUnlockRule bossUnlockRule;
    private int roomNumber;
    private boolean bossUnlocked;
    private boolean gameWon;

    public Game(Hero hero) {
        this.hero = hero;
        this.combatManager = new CombatManager();
        this.shop = new Shop();
        this.healingRule = new HealingRule(25);
        this.rewardRule = new RewardRule(10, 50);
        this.bossUnlockRule = new BossUnlockRule(5);
        this.roomNumber = 1;
        this.currentRoom = createRoom(roomNumber);
        this.bossUnlocked = false;
        this.gameWon = false;
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
            combatManager.heroAttack(hero, currentRoom.getMonster());

            if (!currentRoom.getMonster().isAlive()) {

                if (currentRoom.getMonster().getName().equals("Ancient Shadow Dragon")) {
                    gameWon = true;
                    currentRoom.clearRoom();
                    System.out.println("Victory! You defeated the Ancient Shadow Dragon.");
                    return;
                }

                currentRoom.clearRoom();

                int goldReward = rewardRule.calculateGold(roomNumber);
                int experienceReward = rewardRule.calculateExperience(roomNumber);

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

    public void monsterAttack() {
        if (currentRoom.hasMonster()) {
            combatManager.monsterAttack(currentRoom.getMonster(), hero);
        } 
        else {
            System.out.println("No monster can attack you.");
        }
    }

    public void goToNextRoom() {
        if (!currentRoom.isCleared()) {
            System.out.println("You must clear the current room first.");
            return;
        }

        roomNumber++;
        currentRoom = createRoom(roomNumber);
        
        if (bossUnlockRule.isBossUnlocked(roomNumber)) {
            
            bossUnlocked = true;
            System.out.println("The boss chamber is now unlocked.");
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

        Monster boss = new Monster(
                "Ancient Shadow Dragon",
                180,
                18,
                7,
                6,
                12,
                MonsterPersonality.STRATEGIC
        );

        currentRoom = new Room(
                999,
                "The final chamber burns with shadow fire.",
                boss
        );

        System.out.println("The Ancient Shadow Dragon appears!");
    }

    private Room createRoom(int number) {
        
        Monster monster = new Monster(
                "Goblin Scout",
                35 + number * 10,
                12,
                3,
                2,
                6,
                MonsterPersonality.COWARDLY
        );

        return new Room(
                number,
                "A shadowy dungeon room filled with danger.",
                monster
        );
    }
    
    public HealingRule getHealingRule() {
        
        return healingRule;
    }

    public void setHealingRule(HealingRule healingRule) {
        
        this.healingRule = healingRule;
    }
    
    public void usePotion() {
       
        Potion potion = hero.getInventory().getPotion();

        if (potion == null) {
            System.out.println("No potion available.");
            return;
        }

        potion.use(hero, healingRule);
        hero.getInventory().removeItem(potion);

        combatManager.recordPotionUse();
    }
    
    public RewardRule getRewardRule() {
        
        return rewardRule;
    }

    public void setRewardRule(RewardRule rewardRule) {
        this.rewardRule = rewardRule;
    }
    
    public BossUnlockRule getBossUnlockRule() {
        
        return bossUnlockRule;
    }

    public void setBossUnlockRule(BossUnlockRule bossUnlockRule) {
        
        this.bossUnlockRule = bossUnlockRule;
    }
}