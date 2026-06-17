/**
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class represents the Rogue hero type.
 * Rogue has high accuracy and quick damage.
 */
package dndgame;

public class Rogue extends Hero {

    public Rogue(String name) {
        super(name, 90, 13, 7, 3, 45);
        setEquippedWeapon(new Dagger());
    }

    @Override
    public int attack(Dice dice) {
        
        return dice.roll(6) + getDamageBonus() + getEquippedWeapon().getDamageBonus();
    }
    
    @Override
    public int specialAttack(Dice dice) {

        int damage =
                attack(dice)
                + 10
                + getTemporaryDamageBonus();

        int criticalChance = dice.roll(100);

        if (criticalChance <= 30) {

            damage *= 2;

            System.out.println(
                    getName()
                    + " landed a Shadow Critical!"
            );
        }

        System.out.println(
                getName()
                + " used Shadow Stab!"
        );

        return damage;
    }
    
    @Override
    public String getSpecialAttackName() {
        return "Shadow Stab";
    }
    
}