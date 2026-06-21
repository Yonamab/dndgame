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
package dndgame.items;
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

    public void removeItem(Item item) {
        items.remove(item);
    }
    

    public Potion getPotionAt(int potionIndex) {
        int count = 0;

        for (Item item : items) {
            if (item instanceof Potion) {
                if (count == potionIndex) {
                    return (Potion) item;
                }
                count++;
            }
        }

        return null;
    }
    
    public String[] getPotionNames() {
        ArrayList<String> names = new ArrayList<>();

        for (Item item : items) {
            if (item instanceof Potion) {
                names.add(item.getName());
            }
        }

        return names.toArray(new String[0]);
    }
}