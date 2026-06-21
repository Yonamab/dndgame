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
package dndgame.characters;

import dndgame.items.Dagger;
import dndgame.combat.StandardD6AttackStrategy;
import dndgame.combat.RogueSpecialAttackStrategy;

public class Rogue extends Hero {

    public Rogue(String name) {
        super(name, 90, 13, 7, 3, 45);
        setEquippedWeapon(new Dagger());
        setAttackStrategy(new StandardD6AttackStrategy());
        setSpecialAttackStrategy(new RogueSpecialAttackStrategy(new StandardD6AttackStrategy()));
    }

    @Override
    public String getSpecialAttackName() {
        return "Shadow Stab";
    }
    
}