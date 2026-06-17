/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class starts the Roll of Fate application.
 */
package dndgame.app;

import dndgame.gui.GameWindow;
import javax.swing.SwingUtilities;

public class RollOfFate {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> new GameWindow()
        );
    }
}