/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This potion restores mana for magical heroes.
 */
package dndgame;

public class ManaPotion extends Potion {

    public ManaPotion() {
        super("Mana Potion");
    }

    @Override
    public void use(Hero hero) {

        if (!(hero instanceof Mage)) {
            System.out.println(hero.getName() + " cannot use mana.");
            return;
        }

        Mage mage = (Mage) hero;
        mage.restoreMana(30);

        System.out.println(hero.getName() + " restored 30 mana.");
    }
    
    }