/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This interface defines behavior used by the Roll of Fate application.
 */
package dndgame.combat;

import dndgame.core.Dice;
import dndgame.items.Weapon;

public interface AttackStrategy {
    
    int calculateDamage(Dice dice, int damageBonus, Weapon weapon);
}
