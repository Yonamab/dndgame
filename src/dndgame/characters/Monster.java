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
package dndgame.characters;

import dndgame.combat.MonsterPersonality;
import dndgame.combat.MonsterAttackBehavior;
import dndgame.factory.MonsterType;

public class Monster extends Character {

    private int damageDie;
    private MonsterPersonality personality;
    private MonsterType monsterType;
    private MonsterAttackBehavior attackBehavior;
    
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
    this.monsterType = monsterType;
    this.attackBehavior = null;
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
    
    public void setAttackBehavior(MonsterAttackBehavior behavior) {
        this.attackBehavior = behavior;
    }
    
    public MonsterAttackBehavior getAttackBehavior() {
        return attackBehavior;
    }
    
}