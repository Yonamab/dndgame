/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class creates the graphical user interface for the game.
 */
package dndgame;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DnDGame extends JFrame {

    private Game game;

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

    public DnDGame() {
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
        JPanel panel = createBackgroundPanel("/dndgame/images/Background1.png");
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(40, 40, 40, 40));

        
       

        JPanel formWrapper = new JPanel(new GridBagLayout());
    formWrapper.setOpaque(false);

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

        formWrapper.add(formPanel);

        
        panel.add(formWrapper, BorderLayout.CENTER);

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
        
        JPanel outerPanel = createStyledPanel("Hero");
        outerPanel.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(30, 30, 45));

        heroLabel = createInfoLabel();

        heroHealthBar = new JProgressBar();
        heroHealthBar.setMaximumSize(new Dimension(500, 22));
        heroHealthBar.setPreferredSize(new Dimension(500, 22));
        heroHealthBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        heroHealthBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        heroHealthBar.setStringPainted(true);

        weaponLabel = createInfoLabel();
        roomLabel = createInfoLabel();
        rulesLabel = createInfoLabel();
        effectsLabel = createInfoLabel();
        heroDiceLabel = createInfoLabel();
        damageLabel = createInfoLabel();
        cooldownLabel = createInfoLabel();

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
        scrollPane.setBorder(null);

        outerPanel.add(scrollPane, BorderLayout.CENTER);

        return outerPanel;
    }

    private JPanel createEnemyPanel() {
        JPanel panel = createStyledPanel("Enemy");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        monsterLabel = createInfoLabel();
        monsterHealthBar = new JProgressBar();
        monsterDiceLabel = createInfoLabel();
        monsterHealthBar.setMaximumSize(new Dimension(550, 22));
        monsterHealthBar.setPreferredSize(new Dimension(550, 22));
        monsterHealthBar.setAlignmentX(Component.CENTER_ALIGNMENT);
        monsterHealthBar.setStringPainted(true);
        monsterDiceLabel = createInfoLabel();
        bossPhaseLabel = createInfoLabel();

        panel.add(monsterLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(monsterHealthBar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(monsterDiceLabel);
        panel.add(bossPhaseLabel);

        return panel;
    }

    private JPanel createLogPanel() {
        JPanel panel = createStyledPanel("Game Log");
        panel.setLayout(new BorderLayout());

        logArea = new JTextArea();
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

        JPanel combatPanel = createStyledPanel("Combat");
        combatPanel.setLayout(new GridLayout(5, 1, 6, 6));
        
        JPanel shopPanel = createStyledPanel("Shop");
        shopPanel.setLayout(new GridLayout(3, 1, 6, 6));

        JPanel worldPanel = createStyledPanel("Explore / Rules");
        worldPanel.setLayout(new GridLayout(2, 1, 6, 6));

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

    private JPanel createStyledPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 30, 45));
        panel.setBorder(new CompoundBorder(
                new TitledBorder(
                        new LineBorder(new Color(180, 140, 60), 2),
                        title,
                        TitledBorder.CENTER,
                        TitledBorder.TOP,
                        new Font("Serif", Font.BOLD, 18),
                        new Color(240, 200, 100)
                ),
                new EmptyBorder(12, 12, 12, 12)
        ));
        return panel;
    }

    private JLabel createInfoLabel() {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(new Color(45, 45, 65));
        label.setForeground(Color.WHITE);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setBorder(new EmptyBorder(8, 8, 8, 8));
        return label;
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

        String selectedClass =
                (String) classBox.getSelectedItem();

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

        JCheckBox adaptiveAICheck =
                new JCheckBox("Adaptive AI", true);

        JCheckBox trapsCheck =
                new JCheckBox("Traps Enabled", true);

        JCheckBox bossRageCheck =
                new JCheckBox("Boss Rage Mode", false);

        JCheckBox doubleDiceCheck =
                new JCheckBox("Double Dice Damage", false);

        JCheckBox permadeathCheck =
                new JCheckBox("Permadeath", false);

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
                this,
                rulesPanel,
                "Custom Rules",
                JOptionPane.PLAIN_MESSAGE
        );

        game = new Game(hero);
        setGameButtonsEnabled(true);
        specialAttackReady = true;

        GameRules rules = game.getGameRules();

        rules.setAdaptiveAIEnabled(
                adaptiveAICheck.isSelected()
        );

        rules.setTrapsEnabled(
                trapsCheck.isSelected()
        );

        rules.setBossRageModeEnabled(
                bossRageCheck.isSelected()
        );

        rules.setDoubleDiceEnabled(
                doubleDiceCheck.isSelected()
        );

        rules.setPermadeathEnabled(
                permadeathCheck.isSelected()
        );

        cardLayout.show(rootPanel, "GAME");

        logArea.setText("");

        log(
                "Welcome, "
                + hero.getName()
                + " the "
                + selectedClass
                + "."
        );

        log("Your adventure begins.");
        log("Custom rules selected:");
        log("Adaptive AI: " + game.getGameRules().isAdaptiveAIEnabled());
        log("Traps: " + game.getGameRules().isTrapsEnabled());
        log("Boss Rage: " + game.getGameRules().isBossRageModeEnabled());
        log("Double Dice: " + game.getGameRules().isDoubleDiceEnabled());
        log("Permadeath: " + game.getGameRules().isPermadeathEnabled());
        
        if (game.getCurrentRoom().hasMonster()) {
            log("First encounter: "
                    + game.getCurrentRoom().getMonster().getName()
                    + " appears.");
        }

        updateGUI();
    }

    private void attackMonster() {

        game.heroAttack();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            log(message);
        }

        specialAttackReady = true;

        if (!game.isGameWon()
                && game.getHero().isAlive()
                && game.getCurrentRoom().hasMonster()
                && game.getCurrentRoom().getMonster().isAlive()) {

            game.monsterAttack();

            message = game.getLastGameMessage();

            if (!message.isEmpty()) {
                log(message);
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

        if (!specialAttackReady) {
            log("Special attack is cooling down.");
            return;
        }

        game.heroSpecialAttack();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            log(message);
        }

        specialAttackReady = false;

        if (!game.isGameWon()
                && game.getHero().isAlive()
                && game.getCurrentRoom().hasMonster()
                && game.getCurrentRoom().getMonster().isAlive()) {

            game.monsterAttack();

            message = game.getLastGameMessage();

            if (!message.isEmpty()) {
                log(message);
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
            log("No potions available.");
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
            log("Potion use cancelled.");
            return;
        }

        Potion selectedPotion =
                game.getHero().getInventory().getPotionAt(choice);

        game.usePotion(selectedPotion);

        if (!game.getLastGameMessage().isEmpty()) {
            log(game.getLastGameMessage());
        }

        updateGUI();
    }

    private void buyPotion() {
        String[] options = {
                "Healing Potion - " + Shop.HEALING_POTION_COST + " gold",
                "Mana Potion - " + Shop.MANA_POTION_COST + " gold",
                "Focus Potion - " + Shop.FOCUS_POTION_COST + " gold",
                "Shadow Potion - " + Shop.SHADOW_POTION_COST + " gold",
                "Defense Potion - " + Shop.DEFENSE_POTION_COST + " gold",
                "Weapon Upgrade - " + Shop.WEAPON_UPGRADE_COST + " gold",
                "Armor Upgrade - " + Shop.ARMOR_UPGRADE_COST + " gold",
                "Cancel"
        };

        JComboBox<String> shopBox = new JComboBox<>(options);

        int result = JOptionPane.showConfirmDialog(
                this,
                shopBox,
                "Gold: " + game.getHero().getGold() + " | Dungeon Shop",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        int choice;

        if (result == JOptionPane.OK_OPTION) {
            
            choice = shopBox.getSelectedIndex();
        } 
        
        else {
            choice = 7;
        }

        try {
            switch (choice) {
                case 0:
                    game.getShop().buyHealingPotion(game.getHero());
                    log("Bought Healing Potion.");
                    break;
                case 1:
                    game.getShop().buyManaPotion(game.getHero());
                    log("Bought Mana Potion.");
                    break;
                case 2:
                    game.getShop().buyFocusPotion(game.getHero());
                    log("Bought Focus Potion.");
                    break;
                case 3:
                    game.getShop().buyShadowPotion(game.getHero());
                    log("Bought Shadow Potion.");
                    break;
                case 4:
                    game.getShop().buyDefensePotion(game.getHero());
                    log("Bought Defense Potion.");
                    break;
                case 5:
                    game.getShop().upgradeWeapon(game.getHero());
                    log("Weapon upgraded.");
                    break;
                case 6:
                    game.getShop().upgradeArmor(game.getHero());
                    log("Armor upgraded.");
                    break;
                default:
                    log("Shop closed.");
                    break;
            }
        } catch (IllegalStateException ex) {
            log("Shop error: " + ex.getMessage());
        }

        updateGUI();
    }

    private void nextRoom() {

        game.goToNextRoom();

        String message = game.getLastGameMessage();

        if (!message.isEmpty()) {
            log(message);
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
            
            log(game.getLastGameMessage());
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
        
        if (monster.getMonsterType() == MonsterType.ANCIENT_SHADOW_DRAGON) {

            int bossHPPercent =
                    monster.getCurrentHealth() * 100
                    / monster.getMaxHealth();

            if (bossHPPercent > 50) {
                
                bossPhaseLabel.setText("Boss Phase: Shadow Awakening");
            } else {
                bossPhaseLabel.setText("Boss Phase: Rage of Fate");
            }

        } else {
            
            bossPhaseLabel.setText("Boss Phase: None");
        }

        String heroInfo =
                "<html>Hero: " + hero.getName()
                +"<br>Class: " + hero.getClass().getSimpleName()
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
        heroHealthBar.setString("HP: " + hero.getCurrentHealth() + " / " + hero.getMaxHealth());
        
        weaponLabel.setText(
                "Weapon: "
                + hero.getEquippedWeapon().getName()
                + " | Damage Bonus: +"
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
                        + "<br>Adaptive AI: " + game.getGameRules().isAdaptiveAIEnabled()
                        + "<br>Traps: " + game.getGameRules().isTrapsEnabled()
                        + "<br>Boss Rage: " + game.getGameRules().isBossRageModeEnabled()
                        + "<br>Double Dice: " + game.getGameRules().isDoubleDiceEnabled()
                        + "<br>Permadeath: " + game.getGameRules().isPermadeathEnabled()
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
        monsterHealthBar.setString("HP: " + monster.getCurrentHealth() + " / " + monster.getMaxHealth());
        
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
        
        boolean monsterAlive =
        room.getMonster().isAlive();

        attackButton.setEnabled(monsterAlive);
        
        specialAttackButton.setEnabled(
                monsterAlive
                && specialAttackReady
        );
        
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

    if (game.isGameWon()) {

            setGameButtonsEnabled(false);

            JOptionPane.showMessageDialog(
                    this,
                    "Victory! You defeated the boss."
            );

            cardLayout.show(rootPanel, "START");
            return;
        }
    }

    private void log(String message) {
        logArea.append(message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }
    
    private void upgradeWeapon() {
        try {
            game.getShop().upgradeWeapon(game.getHero());
            log("Weapon upgraded.");
        } catch (IllegalStateException ex) {
            log("Shop error: " + ex.getMessage());
        }

        updateGUI();
    }
    
    private void upgradeArmor() {
        try {
            game.getShop().upgradeArmor(game.getHero());
            log("Armor upgraded.");
        } catch (IllegalStateException ex) {
            log("Shop error: " + ex.getMessage());
        }

        updateGUI();
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
            log(message);
        }

        if (!game.isGameWon()
                && game.getHero().isAlive()
                && game.getCurrentRoom().hasMonster()
                && game.getCurrentRoom().getMonster().isAlive()) {

            game.monsterAttack();

            message = game.getLastGameMessage();

            if (!message.isEmpty()) {
                log(message);
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
    
    private JPanel createBackgroundPanel(String imagePath) {
        return new JPanel() {
            private Image backgroundImage =
                    new ImageIcon(getClass().getResource(imagePath)).getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(
                        backgroundImage,
                        0,
                        0,
                        getWidth(),
                        getHeight(),
                        this
                );
            }
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DnDGame());
    }
}