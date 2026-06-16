/**
 * Project: Roll of Fate
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
    private MonsterPersonality personality;
    private MonsterType monsterType;
    public Monster(MonsterType monsterType,
                String name,
                int maxHealth,
                int armorClass,
                int attackBonus,
                int damageBonus,
                int damageDie,
                MonsterPersonality personality) {
    super(name, maxHealth, armorClass, attackBonus, damageBonus);
    this.damageDie = damageDie;
    this.personality = personality;
    
    }

    public int getDamageDie() {
        return damageDie;
    }
    
    public MonsterType getMonsterType() {
        return monsterType;
    }

    public MonsterPersonality getPersonality() {
        return personality;
    }
    
}