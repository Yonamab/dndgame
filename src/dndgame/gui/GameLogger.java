/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class manages GUI game log messages.
 */
package dndgame.gui;

import javax.swing.JTextArea;

public class GameLogger {

    private JTextArea logArea;

    public GameLogger(JTextArea logArea) {
        this.logArea = logArea;
    }

    public void log(String message) {

        logArea.append(message + "\n");

        logArea.setCaretPosition(
                logArea.getDocument().getLength()
        );
    }

    public void clear() {
        logArea.setText("");
    }
}