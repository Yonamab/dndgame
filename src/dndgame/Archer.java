/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the Archer hero type.
 * Archer has good accuracy and steady ranged damage.
 */
package dndgame;

public class Archer extends Hero {

    public Archer(String name) {
        super(name, 100, 14, 6, 2, 45);
        setEquippedWeapon(new Bow());
    }

    @Override
    public int attack(Dice dice) {
        
        return dice.roll(6) + dice.roll(6) + getDamageBonus() + getEquippedWeapon().getDamageBonus();
    }
    
    @Override
    public int specialAttack(Dice dice) {

        int damage =
                attack(dice)
                + attack(dice)
                + getTemporaryDamageBonus();

        System.out.println(
                getName()
                + " used Piercing Shot!"
        );

        return damage;
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Piercing Shot";
    }
}