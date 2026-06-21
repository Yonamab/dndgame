/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This interface defines behavior used by the Roll of Fate application.
 */
package dndgame.items;

import dndgame.characters.Hero;

public interface Usable {

    void use(Hero hero);
}
