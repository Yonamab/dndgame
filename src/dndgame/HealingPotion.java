/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This potion restores the hero's health.
 */
package dndgame;

public class HealingPotion extends Potion {

    public HealingPotion() {
        super("Healing Potion");
    }

    public void use(Hero hero, HealingRule healingRule) {

        if (hero.isFullHealth()) {
            System.out.println("Health is already full.");
            return;
        }

        int healingAmount =
                healingRule.calculateHealing(hero);

        hero.heal(healingAmount);

        System.out.println(
                hero.getName()
                + " restored "
                + healingAmount
                + " HP."
        );
    }

    @Override
    public void use(Hero hero) {
        use(hero, new HealingRule(25));
    }
}