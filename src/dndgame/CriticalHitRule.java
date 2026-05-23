/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class defines the rule for critical hit damage.
 */
package dndgame;

public class CriticalHitRule implements GameRule {

    private int multiplier;

    public CriticalHitRule(int multiplier) {
        this.multiplier = multiplier;
    }

    public int applyCritical(int damage) {
        return damage * multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String getRuleName() {
        return "Critical Hit Rule";
    }

    @Override
    public String getDescription() {
        return "Defines the damage multiplier used for critical hits.";
    }
}