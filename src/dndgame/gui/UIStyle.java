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
package dndgame.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class UIStyle {

    public static JPanel createStyledPanel(String title) {
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 45));

        panel.setBorder(new CompoundBorder(
            new TitledBorder(
                new LineBorder(new Color(180, 140, 60), 2),
                title,
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Serif", Font.BOLD, 18),
                new Color(240, 200, 100)),
            new EmptyBorder(12, 12, 12, 12))
        );

        return panel;
    }

    public static JLabel createInfoLabel() {
        
        JLabel label = new JLabel();

        label.setOpaque(true);
        label.setBackground(new Color(45, 45, 65));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setBorder(new EmptyBorder(8, 8, 8, 8));

        return label;
    }
}