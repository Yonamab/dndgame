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
package dndgame;

public class Mage extends Hero {

    public Mage(String name) {
        super(name, 85, 12, 4, 3);
        setEquippedWeapon(new Staff());
    }

    @Override
    public int attack(Dice dice) {
        
        return dice.roll(10) + getDamageBonus() + getEquippedWeapon().getDamageBonus();
    }
}