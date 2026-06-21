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
import dndgame.characters.Monster;
import dndgame.characters.Hero;
import dndgame.core.GameRules;

public class DragonAttackBehavior implements MonsterAttackBehavior {
    @Override
    public int calculateDamage(Dice dice, Monster monster, Hero hero, GameRules rules) {
        int baseDamage = dice.roll(monster.getDamageDie()) + monster.getDamageBonus();
        int dragonBreathDamage = dice.roll(12);
        
        System.out.println("The dragon breathes shadow fire for " + dragonBreathDamage + " extra damage.");
        
        return baseDamage + dragonBreathDamage;
    }
}
