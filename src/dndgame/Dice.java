/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents dice rolling behavior for the game.
 * It is used for attack rolls, damage rolls, healing, and random events.
 */
package dndgame;

import java.util.Random;

public class Dice {

    private Random random;

    public Dice() {
        random = new Random();
    }

    public int roll(int sides) {
        if (sides <= 0) {
            throw new IllegalArgumentException("Dice sides must be greater than zero.");
        }

        return random.nextInt(sides) + 1;
    }
}