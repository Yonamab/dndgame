/*
 * Project: Dice Realms: Shadow Dungeon
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

    public Game(Hero hero) {
        this.hero = hero;
        this.combatManager = new CombatManager();
        this.shop = new Shop();
        this.roomNumber = 1;
        this.currentRoom = createRoom(roomNumber);
    }

    public Hero getHero() {
        return hero;
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
                currentRoom.clearRoom();
                hero.addGold(10);
                hero.gainExperience(50);

                System.out.println("Room cleared!");
                System.out.println("You gained 10 gold and 50 experience.");
            }
        } else {
            System.out.println("There is no monster to attack.");
        }
    }

    public void monsterAttack() {
        if (currentRoom.hasMonster()) {
            combatManager.monsterAttack(currentRoom.getMonster(), hero);
        } else {
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

        System.out.println("You entered room " + roomNumber + ".");
        System.out.println(currentRoom.getDescription());
    }

    private Room createRoom(int number) {
        Monster monster = new Monster(
                "Goblin Scout",
                35 + number * 10,
                12,
                6,
                3,
                2
        );

        return new Room(
                number,
                "A shadowy dungeon room filled with danger.",
                monster
        );
    }
}