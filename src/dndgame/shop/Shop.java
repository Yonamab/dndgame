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
package dndgame.shop;

import dndgame.characters.*;
import dndgame.items.Weapon;
import dndgame.items.DefensePotion;
import dndgame.items.ShadowPotion;
import dndgame.items.FocusPotion;
import dndgame.items.ManaPotion;
import dndgame.items.HealingPotion;


public class Shop {

    public static final int HEALING_POTION_COST = 20;
    public static final int MANA_POTION_COST = 20;
    public static final int FOCUS_POTION_COST = 30;
    public static final int SHADOW_POTION_COST = 30;
    public static final int DEFENSE_POTION_COST = 25;
    public static final int WEAPON_UPGRADE_COST = 60;
    public static final int ARMOR_UPGRADE_COST = 60;
    
    public void buyHealingPotion(Hero hero) {

        hero.spendGold(HEALING_POTION_COST);
        hero.getInventory().addItem(new HealingPotion());

        System.out.println(hero.getName() + " bought a healing potion.");
    }
    
    public void upgradeWeapon(Hero hero) {

        hero.spendGold(WEAPON_UPGRADE_COST);

        Weapon weapon = hero.getEquippedWeapon();
        weapon.setDamageBonus(weapon.getDamageBonus() + 2);

        System.out.println(hero.getName()
                + "'s "
                + weapon.getName()
                + " was upgraded.");
    }
    
    public void upgradeArmor(Hero hero) {

        hero.spendGold(ARMOR_UPGRADE_COST);
        hero.increaseArmorBonus(2);

        System.out.println(hero.getName() + "'s armor was upgraded.");
    }
    
    public void buyManaPotion(Hero hero) {
        
       if (!(hero instanceof Mage)) {
           throw new IllegalStateException("Only Mages can buy Mana Potions.");
       }

       hero.spendGold(MANA_POTION_COST);
       hero.getInventory().addItem(new ManaPotion());
   }

    public void buyFocusPotion(Hero hero) {
        
        if (!(hero instanceof Archer)) {
            throw new IllegalStateException("Only Archers can buy Focus Potions.");
        }

        hero.spendGold(FOCUS_POTION_COST);
        hero.getInventory().addItem(new FocusPotion());
    }

    public void buyShadowPotion(Hero hero) {
        
        if (!(hero instanceof Rogue)) {
            throw new IllegalStateException("Only Rogues can buy Shadow Potions.");
        }

        hero.spendGold(SHADOW_POTION_COST);
        hero.getInventory().addItem(new ShadowPotion());
    }

    public void buyDefensePotion(Hero hero) {
        
        if (!(hero instanceof Warrior)) {
            throw new IllegalStateException("Only Warriors can buy Defense Potions.");
        }

        hero.spendGold(DEFENSE_POTION_COST);
        hero.getInventory().addItem(new DefensePotion());
    }
}