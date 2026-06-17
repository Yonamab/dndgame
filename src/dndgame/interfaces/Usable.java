/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This interface represents objects that can be used by a hero.
 */
package dndgame.interfaces;

import dndgame.characters.Hero;

public interface Usable {

    void use(Hero hero);
}