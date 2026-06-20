/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class controls adaptive enemy decision-making using weighted rules,
 * monster personality, player behavior, cooldowns, and boss phases.
 */
package dndgame.combat;

import dndgame.characters.Hero;
import dndgame.characters.Monster;
import java.util.Random;

public class EnemyAI {

    private Random random;
    private int specialCooldown;

    public EnemyAI() {
        random = new Random();
        specialCooldown = 0;
    }

    public EnemyAction chooseAction(
            Monster monster,
            Hero hero,
            PlayerBehaviorTracker tracker) {

        int attackWeight = 60;
        int defendWeight = 25;
        int specialWeight = 15;

        if (specialCooldown > 0) {
            specialWeight = 0;
            specialCooldown--;
        }

        switch (monster.getPersonality()) {

            case COWARDLY:
                defendWeight += 10;

                if (monster.getCurrentHealth()
                        < monster.getMaxHealth() / 2) {

                    defendWeight += 30;
                    attackWeight -= 15;
                    specialWeight -= 10;
                }
                break;

            case AGGRESSIVE:
                attackWeight += 25;
                specialWeight += 15;
                defendWeight -= 15;
                break;

            case STRATEGIC:
                if (hero.getCurrentHealth()
                        < hero.getMaxHealth() / 2) {

                    attackWeight += 20;
                    specialWeight += 20;
                }

                if (tracker.usesPotionsOften()) {
                    specialWeight += 20;
                }

                if (monster.getCurrentHealth()
                        < monster.getMaxHealth() / 3) {

                    defendWeight += 20;
                }
                
                if (tracker.defendsOften()) {
                    specialWeight += 35;
                    attackWeight += 15;
                }
                
                break;

            case SIMPLE:
                attackWeight += 20;
                specialWeight -= 15;
                defendWeight -= 5;
                break;

            case DEFENSIVE:
                defendWeight += 30;
                attackWeight -= 10;
                break;
        }

        if (monster.getCurrentHealth()
                < monster.getMaxHealth() / 3) {

            defendWeight += 15;
            specialWeight += 10;
        }

        if (hero.getCurrentHealth()
                < hero.getMaxHealth() / 3) {

            attackWeight += 25;
        }

        if (tracker.attacksOften()) {
            defendWeight += 15;
        }

        if (tracker.usesPotionsOften()) {
            attackWeight += 25;
            specialWeight += 20;
        }

        attackWeight = Math.max(0, attackWeight);
        defendWeight = Math.max(0, defendWeight);
        specialWeight = Math.max(0, specialWeight);

        int totalWeight =
                attackWeight
                + defendWeight
                + specialWeight;

        int intelligenceRoll =
                random.nextInt(100) + 1;

        if (intelligenceRoll > 85) {
            return randomAction(specialWeight > 0);
        }

        int roll = random.nextInt(totalWeight) + 1;

        if (roll <= attackWeight) {
            return EnemyAction.ATTACK;

        } else if (roll
                <= attackWeight + defendWeight) {

            return EnemyAction.DEFEND;

        } else {

            specialCooldown = 3;
            return EnemyAction.SPECIAL;
        }
    }

    private EnemyAction randomAction(boolean specialAvailable) {

        int roll = random.nextInt(specialAvailable ? 3 : 2);

        if (roll == 0) {
            
            return EnemyAction.ATTACK;

        } 
        
        else if (roll == 1) {
            
            return EnemyAction.DEFEND;

        } 
        
        else {
            
            specialCooldown = 3;
            return EnemyAction.SPECIAL;
        }
    }
}