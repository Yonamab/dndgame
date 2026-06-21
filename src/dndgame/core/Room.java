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
package dndgame.core;

import dndgame.characters.Monster;

public class Room {

    private int roomNumber;
    private String description;
    private Monster monster;
    private boolean cleared;

    public Room(int roomNumber, String description, Monster monster) {
        this.roomNumber = roomNumber;
        this.description = description;
        this.monster = monster;
        this.cleared = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean isCleared() {
        return cleared;
    }

    public void clearRoom() {
        cleared = true;
    }

    public boolean hasMonster() {
        return monster != null && monster.isAlive();
    }
}