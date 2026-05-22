/*
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents a healing potion item.
 * It extends Item and restores health to a hero.
 */
package dndgame;

public class Potion extends Item implements Usable {

    private int healingAmount;

    public Potion() {
        super("Healing Potion");
        this.healingAmount = 25;
    }

    public int getHealingAmount() {
        return healingAmount;
    }

    public void use(Hero hero) {

        if (hero.isFullHealth()) {
            System.out.println("Health is already full. Potion not used.");
            return;
        }

        hero.heal(healingAmount);
        System.out.println(hero.getName() + " used a potion and healed " + healingAmount + " HP.");
    }
}