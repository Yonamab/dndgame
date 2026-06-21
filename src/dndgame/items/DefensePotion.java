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
package dndgame.items;

import dndgame.characters.Hero;
import dndgame.characters.Warrior;
import dndgame.effects.DefenseEffect;

public class DefensePotion extends Potion {

    public DefensePotion() {
        super("Defense Potion");
    }

    @Override
    public void use(Hero hero) {

        if (!(hero instanceof Warrior)) {

            System.out.println(
                    "Only Warriors can use Defense Potion."
            );

            return;
        }

        hero.addStatusEffect(new DefenseEffect());

        System.out.println(
                hero.getName()
                + " gained defense."
        );
    }
}