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

public class ArcherSpecialAttackStrategy implements SpecialAttackStrategy {
    
    private AttackStrategy attackStrategy;
    
    public ArcherSpecialAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    
    @Override
    public int calculateDamage(Dice dice, Hero hero) {
        System.out.println(hero.getName() + " used Piercing Shot!");
        int damage = attackStrategy.calculateDamage(dice, hero.getDamageBonus(), hero.getEquippedWeapon())
                   + attackStrategy.calculateDamage(dice, hero.getDamageBonus(), hero.getEquippedWeapon())
                   + hero.getTemporaryDamageBonus();
        return damage;
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Piercing Shot";
    }
}
