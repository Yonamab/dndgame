/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * Abstract base class for all potion items.
 */
package dndgame.items;

import dndgame.items.Item;
import dndgame.interfaces.Usable;

public abstract class Potion extends Item implements Usable {

    public Potion(String name) {
        super(name);
    }
}