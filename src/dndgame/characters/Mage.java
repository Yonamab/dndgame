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

import dndgame.items.Staff;
import dndgame.combat.StandardD10AttackStrategy;
import dndgame.combat.MageSpecialAttackStrategy;

public class Mage extends Hero {
    
    private int maxMana;
    private int currentMana;

    public Mage(String name) {
        super(name, 95, 12, 4, 3, 35);
        setEquippedWeapon(new Staff());
        this.maxMana = 120;
        this.currentMana = 120;
        setAttackStrategy(new StandardD10AttackStrategy());
        setSpecialAttackStrategy(new MageSpecialAttackStrategy(new StandardD10AttackStrategy()));
    }
    
    public int getMaxMana() {
        return maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }
    
    public boolean hasEnoughManaForSpecial() {
        return currentMana >= 30;
    }

    public void restoreMana(int amount) {
        currentMana += amount;

        if (currentMana > maxMana) {
            currentMana = maxMana;
        }
    }

    public boolean useMana(int amount) {
        if (currentMana < amount) {
            return false;
        }

        currentMana -= amount;
        return true;
    }

    @Override
    public String getSpecialAttackName() {
        return "Arcane Burst";
    }
}