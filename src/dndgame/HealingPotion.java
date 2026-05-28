/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * Healing potion restores hero health.
 */
package dndgame;

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