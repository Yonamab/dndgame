/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class defines the rule for unlocking the boss fight.
 */
package dndgame;

public class BossUnlockRule implements GameRule {

    private int requiredRoom;

    public BossUnlockRule(int requiredRoom) {
        this.requiredRoom = requiredRoom;
    }

    public boolean isBossUnlocked(int currentRoom) {
        return currentRoom >= requiredRoom;
    }

    public int getRequiredRoom() {
        return requiredRoom;
    }

    public void setRequiredRoom(int requiredRoom) {
        this.requiredRoom = requiredRoom;
    }

    @Override
    public String getRuleName() {
        return "Boss Unlock Rule";
    }

    @Override
    public String getDescription() {
        return "Defines the room number required to unlock the boss fight.";
    }
}