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

import dndgame.core.Game;
import dndgame.core.Room;
import dndgame.characters.Mage;
import dndgame.characters.Warrior;
import dndgame.characters.Rogue;
import dndgame.characters.Monster;
import dndgame.characters.Hero;
import dndgame.characters.Archer;
import dndgame.factory.MonsterType;
import dndgame.items.Potion;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private Game game;
    private GameLogger logger;

    private CardLayout cardLayout;
    private JPanel rootPanel;

    private JTextField nameField;
    private JComboBox<String> classBox;

    private JLabel heroLabel;
    private JLabel roomLabel;
    private JLabel monsterLabel;
    private JLabel rulesLabel;
    private JLabel weaponLabel;
    private JLabel heroDiceLabel;
    private JLabel monsterDiceLabel;
    private JLabel damageLabel;
    private JLabel effectsLabel;
    private JLabel cooldownLabel;
    private JLabel bossPhaseLabel;

    private JProgressBar heroHealthBar;
    private JProgressBar monsterHealthBar;

    private JTextArea logArea;

    private JButton attackButton;
    private JButton specialAttackButton;
    private JButton potionButton;
    private JButton shopButton;
    private JButton nextRoomButton;
    private JButton bossButton;
    private JButton defendButton;
   
    private boolean specialAttackReady = true;

    public GameWindow() {
        setTitle("Roll of Fate");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        rootPanel = new JPanel(cardLayout);

        rootPanel.add(createStartScreen(), "START");
        rootPanel.add(createGameScreen(), "GAME");

        add(rootPanel);

        cardLayout.show(rootPanel, "START");
        setVisible(true);
    }

    private JPanel createStartScreen() {

    JPanel panel = new BackgroundPanel("/dndgame/images/Background1.png");
    panel.setLayout(new GridBagLayout()); 
    panel.setBorder(new EmptyBorder(40, 40, 40, 40));
    
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
    formPanel.setOpaque(false);
    formPanel.setMaximumSize(new Dimension(420, 260));

    JLabel nameLabel = new JLabel("Enter Hero Name:");
    nameLabel.setForeground(Color.WHITE);
    nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    nameField = new JTextField("John Snow");
    nameField.setMaximumSize(new Dimension(420, 35));
    nameField.setAlignmentX(Component.CENTER_ALIGNMENT);

    JLabel classLabel = new JLabel("Choose Hero Class:");
    classLabel.setForeground(Color.WHITE);
    classLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    classBox = new JComboBox<>(new String[]{
            "Warrior",
            "Mage",
            "Archer",
            "Rogue"
    });
    classBox.setMaximumSize(new Dimension(420, 35));
    classBox.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton startButton = new JButton("Begin Your Fate");
    startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    startButton.addActionListener(e -> startGame());

    formPanel.add(nameLabel);
    formPanel.add(Box.createVerticalStrut(8));
    formPanel.add(nameField);
    formPanel.add(Box.createVerticalStrut(18));
    formPanel.add(classLabel);
    formPanel.add(Box.createVerticalStrut(8));
    formPanel.add(classBox);
    formPanel.add(Box.createVerticalStrut(25));
    formPanel.add(startButton);

    panel.add(formPanel); 

    return panel;
}

    private JPanel createGameScreen() {
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(15, 15, 25));
        mainPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel titleLabel = new JLabel("ROLL OF FATE", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setForeground(new Color(240, 200, 100));

        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        centerPanel.setBackground(new Color(15, 15, 25));

        centerPanel.add(createHeroPanel());
        centerPanel.add(createLogPanel());
        centerPanel.add(createEnemyPanel());

        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

    private JPanel createHeroPanel() {
        
        JPanel outerPanel = UIStyle.createStyledPanel("Hero");
        outerPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 700));
        panel.setMaximumSize(new Dimension(300, 700));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(30, 30, 45));

        heroLabel = UIStyle.createInfoLabel();

        heroHealthBar = new JProgressBar();
        heroHealthBar.setMaximumSize(new Dimension(511, 22));
        heroHealthBar.setPreferredSize(new Dimension(511, 22));
        heroHealthBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        heroHealthBar.setStringPainted(true);

        weaponLabel = UIStyle.createInfoLabel();
        roomLabel = UIStyle.createInfoLabel();
        rulesLabel = UIStyle.createInfoLabel();
        effectsLabel = UIStyle.createInfoLabel();
        heroDiceLabel = UIStyle.createInfoLabel();
        damageLabel = UIStyle.createInfoLabel();
        cooldownLabel = UIStyle.createInfoLabel();

        panel.add(heroLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(heroHealthBar);
        panel.add(Box.createVerticalStrut(8));
        panel.add(weaponLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(roomLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(rulesLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(effectsLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(cooldownLabel);
        panel.add(Box.createVerticalStrut(8));
        panel.add(heroDiceLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(damageLabel);

        JScrollPane scrollPane = new JScrollPane(panel);
        
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outerPanel.add(scrollPane, BorderLayout.CENTER);

        return outerPanel;
    }

    private JPanel createEnemyPanel() {
        
        JPanel panel = UIStyle.createStyledPanel("Enemy");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        monsterLabel = UIStyle.createInfoLabel();
        monsterDiceLabel = UIStyle.createInfoLabel();
        bossPhaseLabel = UIStyle.createInfoLabel();
        
        monsterHealthBar = new JProgressBar();
        monsterHealthBar.setMaximumSize(new Dimension(550, 22));
        monsterHealthBar.setPreferredSize(new Dimension(550, 22));
        monsterHealthBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        monsterHealthBar.setStringPainted(true);

        panel.add(monsterLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(monsterHealthBar);
        panel.add(Box.createVerticalStrut(5));
        panel.add(monsterDiceLabel);
        panel.add(Box.createVerticalStrut(5));
        panel.add(bossPhaseLabel);

        return panel;
    }

    private JPanel createLogPanel() {
        
        JPanel panel = UIStyle.createStyledPanel("Game Log");
        panel.setLayout(new BorderLayout());

        logArea = new JTextArea();
        logger = new GameLogger(logArea);
        logArea.setEditable(false);
        logArea.setLineWrap(true);
        logArea.setWrapStyleWord(true);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        logArea.setBackground(new Color(10, 10, 15));
        logArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(logArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createButtonPanel() {
        
        JPanel mainButtonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        mainButtonPanel.setBackground(new Color(15, 15, 25));

        JPanel combatPanel = UIStyle.createStyledPanel("Combat");
        combatPanel.setLayout(new GridLayout(5, 1, 6, 6));
        
        JPanel shopPanel = UIStyle.createStyledPanel("Shop");
        shopPanel.setLayout(new GridLayout(3, 1, 6, 6));

        JPanel worldPanel = UIStyle.createStyledPanel("Explore / Rules");
        worldPanel.setLayout(new GridLayout(3, 1, 6, 6));

        attackButton = new JButton("Attack");
        specialAttackButton = new JButton("Special Attack");
        potionButton = new JButton("Inventory / Potions");
        bossButton = new JButton("Boss Fight");
        shopButton = new JButton("Shop");
        nextRoomButton = new JButton("Explore Next Room");
        defendButton = new JButton("Defend");
      
        defendButton.addActionListener(e -> defend());
        attackButton.addActionListener(e -> attackMonster());
        specialAttackButton.addActionListener(e -> specialAttack());
        potionButton.addActionListener(e -> usePotion());
        bossButton.addActionListener(e -> startBossFight());

        shopButton.addActionListener(e -> buyPotion());
        nextRoomButton.addActionListener(e -> nextRoom());
   

        combatPanel.add(attackButton);
        combatPanel.add(defendButton);
        combatPanel.add(specialAttackButton);
        combatPanel.add(potionButton);
        combatPanel.add(bossButton);

        shopPanel.add(shopButton);
    

        worldPanel.add(nextRoomButton);
       

        mainButtonPanel.add(combatPanel);
        mainButtonPanel.add(shopPanel);
        mainButtonPanel.add(worldPanel);

        return mainButtonPanel;
    }

    private void startGame() {

        String heroName = nameField.getText().trim();

        if (heroName.isEmpty()) {
            
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a hero name."
            );
            return;
        }

        String selectedClass = (String) classBox.getSelectedItem();

        Hero hero;

        switch (selectedClass) {

            case "Mage":
                hero = new Mage(heroName);
                break;

            case "Archer":
                hero = new Archer(heroName);
                break;

            case "Rogue":
                hero = new Rogue(heroName);
                break;

            default:
                hero = new Warrior(heroName);
                break;
        }

        game = new Game(hero);
        
        RuleSelectionDialog.show(
                this,
                game.getGameRules()
        );
        
        setGameButtonsEnabled(true);
        
        specialAttackReady = true;

        cardLayout.show(rootPanel, "GAME");

        logger.clear();

        logger.log(
                "Welcome, "
                + hero.getName()
                + " the "
                + selectedClass
                + "."
        );

        logger.log("Your adventure begins.");
        logger.log("Custom rules selected:");
        logger.log("Adaptive AI: " + game.getGameRules().isAdaptiveAIEnabled());
        logger.log("Traps: " + game.getGameRules().isTrapsEnabled());
        logger.log("Boss Rage: " + game.getGameRules().isBossRageModeEnabled());
        logger.log("Double Dice: " + game.getGameRules().isDoubleDiceEnabled());
        logger.log("Permadeath: " + game.getGameRules().isPermadeathEnabled());
        logger.log("First encounter: "
                   + game.getCurrentRoom().getMonster().getName()
                   + " appears.");

        updateGUI();
    }

    private void attackMonster() {

        game.heroAttack();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            logger.log(message);
        }

        specialAttackReady = true;

        if (game.getHero().isAlive()
                && game.getCurrentRoom().hasMonster()
                && game.getCurrentRoom().getMonster().isAlive()) {

            game.monsterAttack();

            message = game.getLastGameMessage();

            if (!message.isEmpty()) {
                logger.log(message);
            }
        }

        updateGUI();

        if (message.contains("revives in the same room")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Permadeath is OFF.\n"
                    + "Your hero revived with full health."
            );
        }

        checkGameEnd();
    }

    private void specialAttack() {

        game.heroSpecialAttack();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            logger.log(message);
        }

        specialAttackReady = false;

        if (game.getHero().isAlive()
                && game.getCurrentRoom().hasMonster()
                && game.getCurrentRoom().getMonster().isAlive()) {

            game.monsterAttack();

            message = game.getLastGameMessage();

            if (!message.isEmpty()) {
                logger.log(message);
            }
        }

        updateGUI();

        if (message.contains("revives in the same room")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Permadeath is OFF.\n"
                    + "Your hero revived with full health."
            );
        }

        checkGameEnd();
    }

    private void usePotion() {

        String[] potionNames =
                game.getHero().getInventory().getPotionNames();

        if (potionNames.length == 0) {
            logger.log("No potions available.");
            return;
        }

        int choice = JOptionPane.showOptionDialog(
                this,
                "Choose a potion to use:",
                "Inventory",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                potionNames,
                potionNames[0]
        );

        if (choice < 0) {
            logger.log("Potion use cancelled.");
            return;
        }

        Potion selectedPotion =
                game.getHero().getInventory().getPotionAt(choice);

        game.usePotion(selectedPotion);

        if (!game.getLastGameMessage().isEmpty()) {
            logger.log(game.getLastGameMessage());
        }

        updateGUI();
    }

    private void buyPotion() {
        int choice = ShopDialog.show(
                this,
                game.getHero()
        );

        try {
            switch (choice) {
                case 0:
                    game.getShop().buyHealingPotion(game.getHero());
                    logger.log("Bought Healing Potion.");
                    break;
                case 1:
                    game.getShop().buyManaPotion(game.getHero());
                    logger.log("Bought Mana Potion.");
                    break;
                case 2:
                    game.getShop().buyFocusPotion(game.getHero());
                    logger.log("Bought Focus Potion.");
                    break;
                case 3:
                    game.getShop().buyShadowPotion(game.getHero());
                    logger.log("Bought Shadow Potion.");
                    break;
                case 4:
                    game.getShop().buyDefensePotion(game.getHero());
                    logger.log("Bought Defense Potion.");
                    break;
                case 5:
                    game.getShop().upgradeWeapon(game.getHero());
                    logger.log("Weapon upgraded.");
                    break;
                case 6:
                    game.getShop().upgradeArmor(game.getHero());
                    logger.log("Armor upgraded.");
                    break;
                default:
                    logger.log("Shop closed.");
                    break;
            }
        } catch (IllegalStateException ex) {
            logger.log("Shop error: " + ex.getMessage());
        }

        updateGUI();
    }

    private void nextRoom() {

        game.goToNextRoom();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            logger.log(message);
        }
        
         updateGUI();
         
        if (message.contains("revives in the same room")) {
                JOptionPane.showMessageDialog(
                      this,
                      "Permadeath is OFF.\n"
                      + "Your hero revived with full health."
                );
         }    
      
        checkGameEnd();
    }

    private void startBossFight() {
        
        game.startBossFight();
        
        if (!game.getLastGameMessage().isEmpty()) {
            
            logger.log(game.getLastGameMessage());
        }
        
        updateGUI();
    }

    private void updateGUI() {

        if (game == null) {
            return;
        }

        Hero hero = game.getHero();
        Room room = game.getCurrentRoom();
        Monster monster = room.getMonster();

        boolean isBoss =
                monster.getMonsterType()
                == MonsterType.ANCIENT_SHADOW_DRAGON;

        boolean bossRageRuleOn =
                game.getGameRules().isBossRageModeEnabled();

        if (isBoss) {

            int bossHPPercent =
                    monster.getCurrentHealth() * 100
                    / monster.getMaxHealth();

            if (bossHPPercent > 50) {

                bossPhaseLabel.setText(
                        "<html>Boss Phase: Shadow Awakening"
                        + "<br>Rage Mode: "
                        + (bossRageRuleOn ? "Enabled" : "Disabled")
                        + "</html>"
                );

            } else {

                if (bossRageRuleOn) {

                    bossPhaseLabel.setText(
                            "<html>Boss Phase: Rage of Fate"
                            + "<br>Rage Mode: Active"
                            + "</html>"
                    );

                } else {

                    bossPhaseLabel.setText(
                            "<html>Boss Phase: Wounded"
                            + "<br>Rage Mode: Disabled"
                            + "</html>"
                    );
                }
            }

        } else {

            bossPhaseLabel.setText(
                    "<html>Boss Phase: None"
                    + "<br>Rage Mode: Not applicable"
                    + "</html>"
            );
        }

        String heroInfo =
                "<html>Hero: " + hero.getName()
                + "<br>Class: " + hero.getClass().getSimpleName()
                + "<br>Gold: " + hero.getGold()
                + "<br>Level: " + hero.getLevel()
                + "<br>Armor: " + hero.getTotalArmorClass()
                + "<br>Items: " + hero.getInventory().getItemCount();

        if (hero instanceof Mage) {

            Mage mage = (Mage) hero;

            heroInfo +=
                    "<br>Mana: "
                    + mage.getCurrentMana()
                    + " / "
                    + mage.getMaxMana();
        }

        heroInfo += "</html>";

        heroLabel.setText(heroInfo);

        heroHealthBar.setMaximum(hero.getMaxHealth());
        heroHealthBar.setValue(hero.getCurrentHealth());
        heroHealthBar.setString(
                "HP: "
                + hero.getCurrentHealth()
                + " / "
                + hero.getMaxHealth()
        );

        weaponLabel.setText(
                "Weapon: "
                + hero.getEquippedWeapon().getName()
                + "|Damga Bonus: +"
                + hero.getEquippedWeapon().getDamageBonus()
        );

        roomLabel.setText(
                "<html>Room: " + room.getRoomNumber()
                + "<br>Boss unlocked: " + game.isBossUnlocked()
                + "<br>Room cleared: " + room.isCleared()
                + "</html>"
        );

        rulesLabel.setText(
                "<html>Rules:"
                + "<br>Adaptive AI: "
                + game.getGameRules().isAdaptiveAIEnabled()
                + "<br>Traps: "
                + game.getGameRules().isTrapsEnabled()
                + "<br>Boss Rage: "
                + game.getGameRules().isBossRageModeEnabled()
                + "<br>Double Dice: "
                + game.getGameRules().isDoubleDiceEnabled()
                + "<br>Permadeath: "
                + game.getGameRules().isPermadeathEnabled()
                + "</html>"
        );

        monsterLabel.setText(
                "<html>Monster: " + monster.getName()
                + "<br>Personality: " + monster.getPersonality()
                + "<br>Armor: " + monster.getArmorClass()
                + "<br>Attack Bonus: +" + monster.getAttackBonus()
                + "<br>Damage Die: D" + monster.getDamageDie()
                + "</html>"
        );
        
        monsterHealthBar.setMaximum(monster.getMaxHealth());
        monsterHealthBar.setValue(monster.getCurrentHealth());
        monsterHealthBar.setString(
                "HP: "
                + monster.getCurrentHealth()
                + " / "
                + monster.getMaxHealth()
        );

        heroDiceLabel.setText(
                "Last D20 Roll: "
                + game.getCombatManager().getLastD20Roll()
        );

        monsterDiceLabel.setText(
                "Last Combat D20 Roll: "
                + game.getCombatManager().getLastD20Roll()
        );

        damageLabel.setText(
                "Last Damage: "
                + game.getCombatManager().getLastDamageRoll()
        );

        effectsLabel.setText(
                "<html>Effects: "
                + hero.getActiveEffectsText()
                + "</html>"
        );

        boolean monsterAlive = room.getMonster().isAlive();
        
        shopButton.setEnabled(!monsterAlive);

        attackButton.setEnabled(monsterAlive);

        boolean canUseSpecial = monsterAlive && specialAttackReady;

        if (hero instanceof Mage) {

            Mage mage = (Mage) hero;

            canUseSpecial =
                    canUseSpecial
                    && mage.hasEnoughManaForSpecial();
        }

        specialAttackButton.setEnabled(canUseSpecial);

        defendButton.setEnabled(monsterAlive);

        if (specialAttackReady) {

            cooldownLabel.setText(
                    "Special Attack: READY"
            );

        } else {

            cooldownLabel.setText(
                    "Special Attack: CHARGING"
            );
        }
    }

    private void checkGameEnd() {

    if (game.isGameOver()) {

        setGameButtonsEnabled(false);

        JOptionPane.showMessageDialog(
                this,
                "Permadeath Enabled.\n"
                + "Your journey ends here."
        );

        cardLayout.show(rootPanel, "START");
        return;
    }

   
    }
 
    private void setGameButtonsEnabled(boolean enabled) {

        attackButton.setEnabled(enabled);
        specialAttackButton.setEnabled(enabled);
        potionButton.setEnabled(enabled);
        shopButton.setEnabled(enabled);
        nextRoomButton.setEnabled(enabled);
        bossButton.setEnabled(enabled);
        defendButton.setEnabled(enabled);
       
        
    }
    
    private void defend() {

        game.heroDefend();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            logger.log(message);
        }

        specialAttackReady = true;

        logger.log("Defending helped you regain focus. Special Attack is ready.\n");

        if (game.getHero().isAlive()
                && game.getCurrentRoom().hasMonster()
                && game.getCurrentRoom().getMonster().isAlive()) {

            game.monsterAttack();

            message = game.getLastGameMessage();

            if (!message.isEmpty()) {
                logger.log(message);
            }
        }

        updateGUI();

        if (message.contains("revives in the same room")) {
            JOptionPane.showMessageDialog(
                    this,
                    "Permadeath is OFF.\n"
                    + "Your hero revived with full health."
            );
        }

        checkGameEnd();
    }
}