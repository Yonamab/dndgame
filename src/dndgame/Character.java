/**
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents a base character in the game.
 * It stores common attributes such as name, health, and armor.
 */
package dndgame;

public class Character {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    private int attackBonus;
    private int damageBonus;

    public Character(String name, int maxHealth, int armorClass, int attackBonus, int damageBonus) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.armorClass = armorClass;
        this.attackBonus = attackBonus;
        this.damageBonus = damageBonus;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
    public void increaseAttackBonus() {
    attackBonus++;
    }
    public int getDamageBonus() {
        return damageBonus;
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }    
    }
     public void heal(int amount) {
        currentHealth += amount;

        if (currentHealth > maxHealth) {
            currentHealth = maxHealth;
        }
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }
    public boolean isFullHealth() {
        return currentHealth == maxHealth;
    }
}