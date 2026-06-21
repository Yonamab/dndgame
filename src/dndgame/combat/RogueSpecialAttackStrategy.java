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

public class RogueSpecialAttackStrategy implements SpecialAttackStrategy {
    
    private AttackStrategy attackStrategy;
    
    public RogueSpecialAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    
    @Override
    public int calculateDamage(Dice dice, Hero hero) {
        int damage = attackStrategy.calculateDamage(dice, hero.getDamageBonus(), hero.getEquippedWeapon())
                   + 10 + hero.getTemporaryDamageBonus();
        
        int criticalChance = dice.roll(100);
        if (criticalChance <= 30) {
            damage *= 2;
            System.out.println(hero.getName() + " landed a Shadow Critical!");
        }
        
        System.out.println(hero.getName() + " used Shadow Stab!");
        return damage;
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Shadow Stab";
    }
}
