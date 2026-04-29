/**
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class stores and manages the hero's items.
 */
package dndgame;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("- " + item.getName());
        }
    }
}