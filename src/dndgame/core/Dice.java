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