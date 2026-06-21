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

import dndgame.items.Sword;
import dndgame.combat.StandardD8AttackStrategy;
import dndgame.combat.WarriorSpecialAttackStrategy;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name, 120, 16, 5, 4, 25);
        setEquippedWeapon(new Sword());
        setAttackStrategy(new StandardD8AttackStrategy());
        setSpecialAttackStrategy(new WarriorSpecialAttackStrategy(new StandardD8AttackStrategy()));
    }

    @Override
    public String getSpecialAttackName() {
        return "Power Strike";
    }
}
