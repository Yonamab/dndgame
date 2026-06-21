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
import dndgame.characters.Rogue;
import dndgame.effects.ShadowEffect;

public class ShadowPotion extends Potion {

    public ShadowPotion() {
        super("Shadow Potion");
    }

    @Override
    public void use(Hero hero) {

        if (!(hero instanceof Rogue)) {

            System.out.println(
                    "Only Rogues can use Shadow Potion."
            );

            return;
        }

        hero.addStatusEffect(new ShadowEffect());

        System.out.println(
                hero.getName()
                + " gained shadow power."
        );
    }
}