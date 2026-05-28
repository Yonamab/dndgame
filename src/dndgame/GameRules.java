/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * Stores customizable gameplay rules.
 */
package dndgame;

public class GameRules {

    private boolean adaptiveAIEnabled;
    private boolean trapsEnabled;
    private boolean bossRageModeEnabled;
    private boolean doubleDiceEnabled;
    private boolean permadeathEnabled;

    public GameRules() {

        adaptiveAIEnabled = true;
        trapsEnabled = true;
        bossRageModeEnabled = false;
        doubleDiceEnabled = false;
        permadeathEnabled = false;
    }

    public boolean isAdaptiveAIEnabled() {
        return adaptiveAIEnabled;
    }

    public void setAdaptiveAIEnabled(
            boolean adaptiveAIEnabled
    ) {
        this.adaptiveAIEnabled = adaptiveAIEnabled;
    }

    public boolean isTrapsEnabled() {
        return trapsEnabled;
    }

    public void setTrapsEnabled(boolean trapsEnabled) {
        this.trapsEnabled = trapsEnabled;
    }

    public boolean isBossRageModeEnabled() {
        return bossRageModeEnabled;
    }

    public void setBossRageModeEnabled(
            boolean bossRageModeEnabled
    ) {
        this.bossRageModeEnabled =
                bossRageModeEnabled;
    }

    public boolean isDoubleDiceEnabled() {
        return doubleDiceEnabled;
    }

    public void setDoubleDiceEnabled(
            boolean doubleDiceEnabled
    ) {
        this.doubleDiceEnabled =
                doubleDiceEnabled;
    }

    public boolean isPermadeathEnabled() {
        return permadeathEnabled;
    }

    public void setPermadeathEnabled(
            boolean permadeathEnabled
    ) {
        this.permadeathEnabled =
                permadeathEnabled;
    }
}