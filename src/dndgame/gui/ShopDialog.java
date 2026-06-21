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
package dndgame.gui;

import dndgame.characters.Hero;
import dndgame.shop.Shop;
import javax.swing.*;

public class ShopDialog {

    public static int show(
              JFrame parent,
              Hero hero) 
    {

        String[] options = {
                "Healing Potion - " + Shop.getHealingPotionCost() + " gold",
                "Mana Potion - " + Shop.getManaPotionCost() + " gold",
                "Focus Potion - " + Shop.getFocusPotionCost() + " gold",
                "Shadow Potion - " + Shop.getShadowPotionCost() + " gold",
                "Defense Potion - " + Shop.getDefensePotionCost() + " gold",
                "Weapon Upgrade - " + Shop.getWeaponUpgradeCost() + " gold",
                "Armor Upgrade - " + Shop.getArmorUpgradeCost() + " gold",
                "Cancel"
        };

        JComboBox<String> shopBox =
                new JComboBox<>(options);

        int result = JOptionPane.showConfirmDialog(
                        parent,
                        shopBox,
                        "Gold: "
                        + hero.getGold()
                        + " | Dungeon Shop",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                    );

        if (result == JOptionPane.OK_OPTION) {
            return shopBox.getSelectedIndex();
        }

        return 7;
    }
}
