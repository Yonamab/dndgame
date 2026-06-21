/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class is part of the Roll of Fate application.
 */
package dndgame.characters;

import dndgame.core.Dice;
import dndgame.items.Weapon;
import dndgame.items.Inventory;
import dndgame.effects.StatusEffect;
import dndgame.combat.AttackStrategy;
import dndgame.combat.SpecialAttackStrategy;
import java.util.ArrayList;

public class Hero extends Character {

    private int level;
    private int experience;
    private int armorBonus;
    private int gold;
    private int defenseReductionPercent;
    
    private Inventory inventory;
    private Weapon equippedWeapon;
    private AttackStrategy attackStrategy;
    private SpecialAttackStrategy specialAttackStrategy;
 
    private boolean defending;
    private ArrayList<StatusEffect> statusEffects;

    public Hero(String name, int maxHealth, int armorClass, int attackBonus, int damageBonus,int defenseReductionPercent) {
        super(name, maxHealth, armorClass, attackBonus, damageBonus);
        this.level = 1;
        this.experience = 0;
        this.gold = 25;
        this.armorBonus = 0;
        this.defenseReductionPercent = defenseReductionPercent;
        this.defending = false;
        this.statusEffects = new ArrayList<>();
        this.inventory = new Inventory();
        this.attackStrategy = null;
        this.specialAttackStrategy = null;
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
        if (attackStrategy == null) {
            throw new IllegalStateException("Attack strategy not set for " + getName());
        }
        return attackStrategy.calculateDamage(dice, getDamageBonus(), equippedWeapon);
    }
    
    public int specialAttack(Dice dice) {
        if (specialAttackStrategy == null) {
            throw new IllegalStateException("Special attack strategy not set for " + getName());
        }
        return specialAttackStrategy.calculateDamage(dice, this);
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
    
    public int getEquippedWeaponDamage() {
        if (equippedWeapon == null) {
            return 0;
        }
        return equippedWeapon.getDamageBonus();
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

        ArrayList<String> parts = new ArrayList<>();

        for (StatusEffect effect : statusEffects) {
            parts.add(effect.getName() + " [" + effect.getDuration() + " turns]");
        }

        return String.join(", ", parts);
    }

    public boolean hasActiveStatusEffects() {
        return !statusEffects.isEmpty();
    }
    
    public String getSpecialAttackName() {
        if (specialAttackStrategy == null) {
            return "Strike of Doom";
        }
        return specialAttackStrategy.getSpecialAttackName();
    }
    
    protected void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
    }
    
    protected void setSpecialAttackStrategy(SpecialAttackStrategy strategy) {
        this.specialAttackStrategy = strategy;
    }
    
    public void defend() {
        defending = true;
    }

    public boolean isDefending() {
        return defending;
    }

    public int getDefenseReductionPercent() {
        return defenseReductionPercent;
    }
    
    @Override
    public void takeDamage(int damage) {
        if (defending) {
            damage = damage - (damage * getDefenseReductionPercent() / 100);
            defending = false;
        }

        super.takeDamage(damage);
    }

}