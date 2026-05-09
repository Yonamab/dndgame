/*
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class creates the main graphical window for the game.
 */
package dndgame;

import javax.swing.*;
import java.awt.*;

public class DnDGame extends JFrame {

    private Game game;

    private JLabel heroLabel;
    private JLabel roomLabel;
    private JLabel monsterLabel;
    private JTextArea logArea;
    private JButton attackButton;

    public DnDGame() {
        Hero hero = new Warrior("Aldric");
        game = new Game(hero);

        setTitle("Dice Realms: Shadow Dungeon");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createGUI();

        setVisible(true);
    }

    private void createGUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Dice Realms: Shadow Dungeon", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 28));

        JPanel statsPanel = new JPanel(new GridLayout(3, 1));

        heroLabel = new JLabel();
        roomLabel = new JLabel();
        monsterLabel = new JLabel();

        statsPanel.add(heroLabel);
        statsPanel.add(roomLabel);
        statsPanel.add(monsterLabel);

        logArea = new JTextArea();
        logArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(logArea);

        attackButton = new JButton("Attack");
        attackButton.addActionListener(e -> attackMonster());

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(statsPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(attackButton, BorderLayout.SOUTH);

        add(mainPanel);

        updateGUI();
        log("Game started.");
    }

    private void attackMonster() {
        game.heroAttack();
        game.monsterAttack();

        log("You attacked the monster.");
        updateGUI();
    }

    private void updateGUI() {
        Hero hero = game.getHero();
        Room room = game.getCurrentRoom();
        Monster monster = room.getMonster();

        heroLabel.setText("Hero: " + hero.getName() + " | HP: " + hero.getCurrentHealth());
        roomLabel.setText("Room: " + room.getRoomNumber());
        monsterLabel.setText("Monster: " + monster.getName() + " | HP: " + monster.getCurrentHealth());
    }

    private void log(String message) {
        logArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DnDGame());
    }
}