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

import dndgame.items.Bow;
import dndgame.combat.DualD6AttackStrategy;
import dndgame.combat.ArcherSpecialAttackStrategy;

public class Archer extends Hero {

    public Archer(String name) {
        super(name, 100, 14, 6, 2, 45);
        setEquippedWeapon(new Bow());
        setAttackStrategy(new DualD6AttackStrategy());
        setSpecialAttackStrategy(new ArcherSpecialAttackStrategy(new DualD6AttackStrategy()));
    }

    @Override
    public String getSpecialAttackName() {
        return "Piercing Shot";
    }
}