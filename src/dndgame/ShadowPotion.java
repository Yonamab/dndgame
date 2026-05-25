/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This potion gives the hero a temporary damage bonus.
 */
package dndgame;

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