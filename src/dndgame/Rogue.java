/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the Rogue hero type.
 * Rogue has high accuracy and quick damage.
 */
package dndgame;

public class Rogue extends Hero {

    public Rogue(String name) {
        super(name, 90, 13, 7, 3);
        setEquippedWeapon(new Dagger());
    }

    @Override
    public int attack(Dice dice) {
        
        return dice.roll(6) + getDamageBonus() + getEquippedWeapon().getDamageBonus();
    }
}