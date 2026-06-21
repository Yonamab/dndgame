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
import dndgame.characters.Mage;

public class MageSpecialAttackStrategy implements SpecialAttackStrategy {
    
    private AttackStrategy attackStrategy;
    
    public MageSpecialAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
    
    @Override
    public int calculateDamage(Dice dice, Hero hero) {
        Mage mage = (Mage) hero;
        
        if (!mage.useMana(30)) {
            System.out.println(hero.getName() + " does not have enough mana.");
            return 0;
        }
        
        System.out.println(hero.getName() + " used Arcane Burst!");
        return attackStrategy.calculateDamage(dice, hero.getDamageBonus(), hero.getEquippedWeapon())
               + 18 + hero.getTemporaryDamageBonus();
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Arcane Burst";
    }
}
