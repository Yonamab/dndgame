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

public class StandardMonsterAttackBehavior implements MonsterAttackBehavior {
    @Override
    public int calculateDamage(Dice dice, Monster monster, Hero hero, GameRules rules) {
        return dice.roll(monster.getDamageDie()) + monster.getDamageBonus();
    }
}
