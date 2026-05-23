/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class defines the rule for potion healing.
 */
package dndgame;

public class HealingRule implements GameRule {

    private int healingPercent;

    public HealingRule(int healingPercent) {
        this.healingPercent = healingPercent;
    }

    public int calculateHealing(Hero hero) {
        return hero.getMaxHealth() * healingPercent / 100;
    }

    public int getHealingPercent() {
        return healingPercent;
    }

    public void setHealingPercent(int healingPercent) {
        this.healingPercent = healingPercent;
    }

    @Override
    public String getRuleName() {
        return "Healing Rule";
    }

    @Override
    public String getDescription() {
        return "Defines the percentage of maximum health restored by potions.";
    }
}