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
package dndgame.effects;

public abstract class StatusEffect {

    private String name;
    private int duration;

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isExpired() {
        return duration <= 0;
    }

    public void decreaseDuration() {
        duration--;
    }

    public abstract int getAttackBonus();

    public abstract int getDamageBonus();

    public abstract int getArmorBonus();
}