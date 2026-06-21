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
package dndgame.effects;
public class ShadowEffect extends StatusEffect implements DamageBonusEffect {

    public ShadowEffect() {
        super("Shadow Power", 3);
    }

    @Override
    public int getAttackBonus() {
        return 0;
    }

    @Override
    public int getDamageBonus() {
        return 4;
    }

    @Override
    public int getArmorBonus() {
        return 0;
    }
}