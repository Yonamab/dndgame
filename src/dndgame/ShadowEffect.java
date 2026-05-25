/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This status effect increases the hero's damage temporarily.
 */
package dndgame;

public class ShadowEffect extends StatusEffect {

    public ShadowEffect() {
        super("Shadow Power", 3);
    }

    public int getAttackBonus() {
        return 0;
    }

    public int getDamageBonus() {
        return 4;
    }

    public int getArmorBonus() {
        return 0;
    }
}