/**
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the player controlled hero.
 * It extends the Character class and adds level and experience.
 */
package dndgame;

public class Hero extends Character {

    private int level;
    private int experience;

    public Hero(String name, int maxHealth, int armorClass) {
        super(name, maxHealth, armorClass); // calls Character constructor
        this.level = 1;
        this.experience = 0;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public void gainExperience(int amount) {
        experience += amount;

        if (experience >= 100) {
            level++;
            experience = 0;
            System.out.println(getName() + " leveled up to level " + level);
        }
    }
}