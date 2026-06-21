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
package dndgame.shop;

import dndgame.characters.Hero;
import dndgame.characters.Warrior;

public class WarriorOnlyValidator implements PotionValidator {
    @Override
    public boolean canUse(Hero hero) {
        return hero instanceof Warrior;
    }
    
    @Override
    public String getErrorMessage() {
        return "Only Warriors can use this potion.";
    }
}
