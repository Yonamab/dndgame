/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class defines the rule for gold and experience rewards.
 */
package dndgame;

public class RewardRule implements GameRule {

    private int baseGold;
    private int baseExperience;

    public RewardRule(int baseGold, int baseExperience) {
        this.baseGold = baseGold;
        this.baseExperience = baseExperience;
    }

    public int calculateGold(int roomNumber) {
        return baseGold + roomNumber * 2;
    }

    public int calculateExperience(int roomNumber) {
        return baseExperience + roomNumber * 5;
    }

    public int getBaseGold() {
        return baseGold;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseGold(int baseGold) {
        this.baseGold = baseGold;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    @Override
    public String getRuleName() {
        return "Reward Rule";
    }

    @Override
    public String getDescription() {
        return "Defines how gold and experience rewards are calculated.";
    }
}