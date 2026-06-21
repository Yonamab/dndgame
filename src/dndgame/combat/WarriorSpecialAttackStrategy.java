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
import dndgame.characters.Hero;

public class WarriorSpecialAttackStrategy implements SpecialAttackStrategy {
    
    private AttackStrategy attackStrategy;
    
    public WarriorSpecialAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    
    @Override
    public int calculateDamage(Dice dice, Hero hero) {
        System.out.println(hero.getName() + " used Power Strike!");
        return attackStrategy.calculateDamage(dice, hero.getDamageBonus(), hero.getEquippedWeapon())
               + 8 + hero.getTemporaryDamageBonus();
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Power Strike";
    }
}
