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
package dndgame.combat;

import dndgame.core.Dice;
import dndgame.items.Weapon;

public class DualD6AttackStrategy implements AttackStrategy {
    @Override
    public int calculateDamage(Dice dice, int damageBonus, Weapon weapon) {
        int weaponDamage = 0;
        if (weapon != null) {
            weaponDamage = weapon.getDamageBonus();
        }
        return dice.roll(6) + dice.roll(6) + damageBonus + weaponDamage;
    }
}
