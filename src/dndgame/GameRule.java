/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This interface represents customizable gameplay rules.
 */
package dndgame;

public interface GameRule {

    String getRuleName();

    String getDescription();
}