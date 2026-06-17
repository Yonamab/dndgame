/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class tracks the player's behavior during gameplay.
 * The enemy AI can use this information to make smarter decisions.
 */
package dndgame.combat;

public class PlayerBehaviorTracker {

    private int attackCount;
    private int potionUseCount;
    private int defendUses;

    public PlayerBehaviorTracker() {
        attackCount = 0;
        potionUseCount = 0;
    }

    public void recordAttack() {
        attackCount++;
    }

    public void recordPotionUse() {
        potionUseCount++;
    }

    public int getAttackCount() {
        return attackCount;
    }

    public int getPotionUseCount() {
        return potionUseCount;
    }

    public boolean attacksOften() {
        return attackCount >= 3;
    }

    public boolean usesPotionsOften() {
        return potionUseCount >= 2;
    }
    
    public void recordDefendUse() {
        
        defendUses++;
    }
    
    public boolean defendsOften() {
        
        return defendUses >= 2;
    }
}