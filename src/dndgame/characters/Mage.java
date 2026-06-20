/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the Mage hero type.
 * Mage has lower health but higher magical damage.
 */
package dndgame.characters;

import dndgame.core.Dice;
import dndgame.characters.Hero;
import dndgame.items.Staff;

public class Mage extends Hero {
    
    private int maxMana;
    private int currentMana;

    public Mage(String name) {
        super(name, 95, 12, 4, 3, 35);
        setEquippedWeapon(new Staff());
        this.maxMana = 120;
        this.currentMana = 120;
    }

    @Override
    public int attack(Dice dice) {
        
        return dice.roll(10) + getDamageBonus() + getEquippedWeapon().getDamageBonus();
    }
    
    @Override
    public int specialAttack(Dice dice) {

        if (!useMana(30)) {

            System.out.println(
                    getName()
                    + " does not have enough mana."
            );

            return 0;
        }
        
        int damage =
                attack(dice)
                + 18
                + getTemporaryDamageBonus();

        System.out.println(
                getName()
                + " used Arcane Burst!"
        );

        return damage;
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