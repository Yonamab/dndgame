/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the Warrior hero type.
 * Warrior has high health, strong armor, and reliable melee damage.
 */
package dndgame;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name, 125, 16, 5, 4);
    }

    @Override
    public int attack(Dice dice) {
        return dice.roll(8) + getDamageBonus();
    }
}