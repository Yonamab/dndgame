/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This status effect increases the hero's armor temporarily.
 */
package dndgame;

public class DefenseEffect extends StatusEffect {

    public DefenseEffect() {
        super("Defense", 3);
    }

    public int getAttackBonus() {
        return 0;
    }

    public int getDamageBonus() {
        return 0;
    }

    public int getArmorBonus() {
        return 3;
    }
}