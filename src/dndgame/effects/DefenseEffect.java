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

public class DefenseEffect extends StatusEffect implements ArmorBonusEffect {

    public DefenseEffect() {
        super("Defense", 3);
    }

    @Override
    public int getAttackBonus() {
        return 0;
    }

    @Override
    public int getDamageBonus() {
        return 0;
    }

    @Override
    public int getArmorBonus() {
        return 3;
    }
}