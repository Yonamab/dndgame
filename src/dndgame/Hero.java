/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the player-controlled hero.
 * It extends Character and provides common hero features.
 */
package dndgame;

public class Hero extends Character {

    private int level;
    private int experience;
    private Weapon equippedWeapon;
    private int gold;
    private Inventory inventory;
    private int armorBonus;

    public Hero(String name, int maxHealth, int armorClass, int attackBonus, int damageBonus) {
        super(name, maxHealth, armorClass, attackBonus, damageBonus);
        this.level = 1;
        this.experience = 0;
        this.gold = 25;
        this.armorBonus = 0;
        this.inventory = new Inventory();
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

            increaseAttackBonus();

            System.out.println(getName() + " leveled up to level " + level);
        }
    }

    public int attack(Dice dice) {
        
        int weaponDamage = 0;

        if (equippedWeapon != null) {
            weaponDamage = equippedWeapon.getDamageBonus();
        }

        return dice.roll(8) + getDamageBonus() + weaponDamage;
    }
    
    public Inventory getInventory() {
        return inventory;
    }
    
    public int getGold() {
        return gold;
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public void spendGold(int amount) {
        if (gold < amount) {
            throw new IllegalStateException("Not enough gold.");
        }

        gold -= amount;
    }
    
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }
    public int getArmorBonus() {
        return armorBonus;
    }

    public void increaseArmorBonus(int amount) {
        armorBonus += amount;
    }

    public int getTotalArmorClass() {
        return getArmorClass() + armorBonus;
    }
}