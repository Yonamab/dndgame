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
import dndgame.characters.Rogue;

public class RogueOnlyValidator implements PotionValidator {
    @Override
    public boolean canUse(Hero hero) {
        return hero instanceof Rogue;
    }
    
    @Override
    public String getErrorMessage() {
        return "Only Rogues can use this potion.";
    }
}
