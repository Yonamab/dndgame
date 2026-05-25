/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This status effect increases the hero's attack accuracy temporarily.
 */
package dndgame;

public class FocusEffect extends StatusEffect {

    public FocusEffect() {
        super("Focus", 3);
    }

    public int getAttackBonus() {
        return 3;
    }

    public int getDamageBonus() {
        return 0;
    }

    public int getArmorBonus() {
        return 0;
    }
}