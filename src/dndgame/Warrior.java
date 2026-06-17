/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the Warrior hero type.
 * Warrior has high health, strong armor, and reliable melee damage.
 */
package dndgame;

public class Warrior extends Hero {

    public Warrior(String name) {
        
        super(name, 125, 16, 5, 4, 60);
        
        setEquippedWeapon(new Sword());
    }

    @Override
    public int attack(Dice dice) {
        
        return dice.roll(8) + getDamageBonus() + getEquippedWeapon().getDamageBonus();
    }
    
    @Override
    public int specialAttack(Dice dice) {

        int damage =
                attack(dice)
                + 8
                + getTemporaryDamageBonus();

        System.out.println(
                getName()
                + " used Power Strike!"
        );

        return damage;
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Power Strike";
    }
}