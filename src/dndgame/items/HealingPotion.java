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

public class HealingPotion extends Potion {

    public HealingPotion() {
        super("Healing Potion");
    }

    @Override
    public void use(Hero hero) {

        int healAmount =
                hero.getMaxHealth() / 2;

        hero.heal(healAmount);

        System.out.println(
                hero.getName()
                + " restored "
                + healAmount
                + " HP."
        );
    }
}