/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class displays the shop dialog and returns the player's shop choice.
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
                "Healing Potion - " + Shop.HEALING_POTION_COST + " gold",
                "Mana Potion - " + Shop.MANA_POTION_COST + " gold",
                "Focus Potion - " + Shop.FOCUS_POTION_COST + " gold",
                "Shadow Potion - " + Shop.SHADOW_POTION_COST + " gold",
                "Defense Potion - " + Shop.DEFENSE_POTION_COST + " gold",
                "Weapon Upgrade - " + Shop.WEAPON_UPGRADE_COST + " gold",
                "Armor Upgrade - " + Shop.ARMOR_UPGRADE_COST + " gold",
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