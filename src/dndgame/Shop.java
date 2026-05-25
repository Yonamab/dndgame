/*
 * Project: Roll of Fate
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
        
        int potionPrice = 15;

        hero.spendGold(potionPrice);
        hero.getInventory().addItem(new HealingPotion());

        System.out.println(hero.getName() + " bought a healing potion.");
    }
    
    public void upgradeWeapon(Hero hero) {
        int upgradeCost = 45;

        hero.spendGold(upgradeCost);

        Weapon weapon = hero.getEquippedWeapon();
        weapon.setDamageBonus(weapon.getDamageBonus() + 2);

        System.out.println(hero.getName()
                + "'s "
                + weapon.getName()
                + " was upgraded.");
    }
    
    public void upgradeArmor(Hero hero) {
        int upgradeCost = 45;

        hero.spendGold(upgradeCost);
        hero.increaseArmorBonus(2);

        System.out.println(hero.getName() + "'s armor was upgraded.");
    }
    
    public void buyManaPotion(Hero hero) {
        int cost = 20;

        hero.spendGold(cost);
        hero.getInventory().addItem(new ManaPotion());

        System.out.println(hero.getName() + " bought a mana potion.");
    }

    public void buyFocusPotion(Hero hero) {
        int cost = 20;

        hero.spendGold(cost);
        hero.getInventory().addItem(new FocusPotion());

        System.out.println(hero.getName() + " bought a focus potion.");
    }

    public void buyShadowPotion(Hero hero) {
        int cost = 25;

        hero.spendGold(cost);
        hero.getInventory().addItem(new ShadowPotion());

        System.out.println(hero.getName() + " bought a shadow potion.");
    }

    public void buyDefensePotion(Hero hero) {
        int cost = 20;

        hero.spendGold(cost);
        hero.getInventory().addItem(new DefensePotion());

        System.out.println(hero.getName() + " bought a defense potion.");
    }
}