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
package dndgame.shop;

import dndgame.characters.*;
import dndgame.items.Weapon;
import dndgame.items.DefensePotion;
import dndgame.items.ShadowPotion;
import dndgame.items.FocusPotion;
import dndgame.items.ManaPotion;
import dndgame.items.HealingPotion;
import java.util.HashMap;
import java.util.Map;

public class Shop {

    private static final int HEALING_POTION_COST = 20;
    private static final int MANA_POTION_COST = 20;
    private static final int FOCUS_POTION_COST = 30;
    private static final int SHADOW_POTION_COST = 30;
    private static final int DEFENSE_POTION_COST = 25;
    private static final int WEAPON_UPGRADE_COST = 60;
    private static final int ARMOR_UPGRADE_COST = 60;
    
    private static final Map<String, PotionValidator> validators = new HashMap<>();
    
    static {
        validators.put("mana", new MageOnlyValidator());
        validators.put("focus", new ArcherOnlyValidator());
        validators.put("shadow", new RogueOnlyValidator());
        validators.put("defense", new WarriorOnlyValidator());
    }

    public static int getHealingPotionCost() {
        return HEALING_POTION_COST;
    }

    public static int getManaPotionCost() {
        return MANA_POTION_COST;
    }

    public static int getFocusPotionCost() {
        return FOCUS_POTION_COST;
    }

    public static int getShadowPotionCost() {
        return SHADOW_POTION_COST;
    }

    public static int getDefensePotionCost() {
        return DEFENSE_POTION_COST;
    }

    public static int getWeaponUpgradeCost() {
        return WEAPON_UPGRADE_COST;
    }

    public static int getArmorUpgradeCost() {
        return ARMOR_UPGRADE_COST;
    }
    
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
        validateAndBuyPotion(hero, "mana", new ManaPotion(), MANA_POTION_COST);
    }

    public void buyFocusPotion(Hero hero) {
        validateAndBuyPotion(hero, "focus", new FocusPotion(), FOCUS_POTION_COST);
    }

    public void buyShadowPotion(Hero hero) {
        validateAndBuyPotion(hero, "shadow", new ShadowPotion(), SHADOW_POTION_COST);
    }

    public void buyDefensePotion(Hero hero) {
        validateAndBuyPotion(hero, "defense", new DefensePotion(), DEFENSE_POTION_COST);
    }
    
    private void validateAndBuyPotion(Hero hero, String potionType, dndgame.items.Item potion, int cost) {
        PotionValidator validator = validators.get(potionType);
        
        if (validator != null && !validator.canUse(hero)) {
            throw new IllegalStateException(validator.getErrorMessage());
        }
        
        hero.spendGold(cost);
        hero.getInventory().addItem(potion);
    }
}
