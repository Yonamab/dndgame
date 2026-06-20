/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class displays the custom rule selection dialog.
 */
package dndgame.gui;

import dndgame.core.GameRules;
import javax.swing.*;

public class RuleSelectionDialog {

    public static void show( JFrame parent, GameRules rules) 
    
    {

        JCheckBox adaptiveAICheck = new JCheckBox("Adaptive AI", true);

        JCheckBox trapsCheck = new JCheckBox("Traps Enabled", true);

        JCheckBox bossRageCheck =  new JCheckBox("Boss Rage Mode", false);

        JCheckBox doubleDiceCheck = new JCheckBox("Double Dice Damage", false);

        JCheckBox permadeathCheck =  new JCheckBox("Permadeath", false);

        JPanel rulesPanel = new JPanel();

        rulesPanel.setLayout(
                new BoxLayout(
                        rulesPanel,
                        BoxLayout.Y_AXIS
                )
        );

        rulesPanel.add(adaptiveAICheck);
        rulesPanel.add(trapsCheck);
        rulesPanel.add(bossRageCheck);
        rulesPanel.add(doubleDiceCheck);
        rulesPanel.add(permadeathCheck);

        JOptionPane.showMessageDialog(
                parent,
                rulesPanel,
                "Custom Rules",
                JOptionPane.PLAIN_MESSAGE
        );

        rules.setAdaptiveAIEnabled( adaptiveAICheck.isSelected() );

        rules.setTrapsEnabled( trapsCheck.isSelected() );

        rules.setBossRageModeEnabled(
                bossRageCheck.isSelected()
        );

        rules.setDoubleDiceEnabled(
                doubleDiceCheck.isSelected()
        );

        rules.setPermadeathEnabled(
                permadeathCheck.isSelected()
        );
    }
}