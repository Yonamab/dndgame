/**
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents an enemy monster in the game.
 * It extends Character and adds damage dice and attack bonus.
 */
package dndgame;

public class Monster extends Character {

    private int damageDie;
    private int attackBonus;

    public Monster(String name, int maxHealth, int armorClass, int damageDie, int attackBonus) {
        super(name, maxHealth, armorClass);
        this.damageDie = damageDie;
        this.attackBonus = attackBonus;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}