/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
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
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (Item item : items) {
            System.out.println("- " + item.getName());
        }
    }

    public Potion getPotion() {
        for (Item item : items) {
            if (item instanceof Potion) {
                return (Potion) item;
            }
        }

        return null;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }
}