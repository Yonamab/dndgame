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
import dndgame.characters.Hero;

public interface SpecialAttackStrategy {
    

    int calculateDamage(Dice dice, Hero hero);
    
    

    String getSpecialAttackName();
}
