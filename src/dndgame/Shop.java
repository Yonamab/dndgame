/*
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the shop where the hero can buy items.
 */
package dndgame;

public class Shop {

    private int potionPrice;

    public Shop() {
        this.potionPrice = 15;
    }

    public void buyPotion(Hero hero) {
        hero.spendGold(potionPrice);
        hero.getInventory().addItem(new Potion());

        System.out.println(hero.getName() + " bought a healing potion.");
    }
}