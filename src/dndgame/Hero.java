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

import java.util.ArrayList;

public class Hero extends Character {

    private int level;
    private int experience;
    private Weapon equippedWeapon;
    private int gold;
    private Inventory inventory;
    private int armorBonus;
    private ArrayList<StatusEffect> statusEffects;

    public Hero(String name, int maxHealth, int armorClass, int attackBonus, int damageBonus) {
        super(name, maxHealth, armorClass, attackBonus, damageBonus);
        this.level = 1;
        this.experience = 0;
        this.gold = 25;
        this.armorBonus = 0;
        this.statusEffects = new ArrayList<>();
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
    
    public int specialAttack(Dice dice) {
        
        return attack(dice) + getTemporaryDamageBonus();
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
        return getArmorClass() + armorBonus + getTemporaryArmorBonus();
    }
    
    public void addStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
    }

    public int getTemporaryAttackBonus() {
        int total = 0;

        for (StatusEffect effect : statusEffects) {
            total += effect.getAttackBonus();
        }

        return total;
    }

    public int getTemporaryDamageBonus() {
        int total = 0;

        for (StatusEffect effect : statusEffects) {
            total += effect.getDamageBonus();
        }

        return total;
    }

    public int getTemporaryArmorBonus() {
        int total = 0;

        for (StatusEffect effect : statusEffects) {
            total += effect.getArmorBonus();
        }

        return total;
    }

    public void updateStatusEffects() {
        for (int i = statusEffects.size() - 1; i >= 0; i--) {
            StatusEffect effect = statusEffects.get(i);
            effect.decreaseDuration();

            if (effect.isExpired()) {
                statusEffects.remove(i);
            }
        }
    }
    
    public String getActiveEffectsText() {

        if (statusEffects.isEmpty()) {
            return "None";
        }

        StringBuilder builder = new StringBuilder();

        for (StatusEffect effect : statusEffects) {

            builder.append(effect.getName())
                   .append(" [")
                   .append(effect.getDuration())
                   .append(" turns]")
                   .append("<br>");

        }

        return builder.toString();
    }
    
    public String getSpecialAttackName() {
    
        return "Strike of Doom";
    }

}