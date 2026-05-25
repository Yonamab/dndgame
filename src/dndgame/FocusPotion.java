/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This potion gives the hero a temporary attack bonus.
 */
package dndgame;

public class FocusPotion extends Potion {

    public FocusPotion() {
        super("Focus Potion");
    }

    @Override
    public void use(Hero hero) {

        if (!(hero instanceof Archer)) {

            System.out.println(
                    "Only Archers can use Focus Potion."
            );

            return;
        }

        hero.addStatusEffect(new FocusEffect());

        System.out.println(
                hero.getName()
                + " gained focus."
        );
    }
}