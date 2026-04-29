/**
 * Project: Dice Realms: Shadow Dungeon
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class manages basic combat between a hero and a monster.
 * It uses dice rolls to decide attacks and damage.
 */
package dndgame;

public class CombatManager {

    private Dice dice;

    public CombatManager() {
        dice = new Dice();
    }

    public void heroAttack(Hero hero, Monster monster) {
        int d20 = dice.roll(20);
        int totalAttack = d20 + hero.getAttackBonus();

        System.out.println(hero.getName() + " rolls D20: " + d20);
        System.out.println("Total attack: " + totalAttack);

        if (totalAttack >= monster.getArmorClass()) {
            int damage = hero.attack(dice);

            monster.takeDamage(damage);

            System.out.println(hero.getName() + " hits " + monster.getName());
            System.out.println("Damage dealt: " + damage);} 
        else {
            System.out.println(hero.getName() + " misses " + monster.getName());
        }
}

    public void monsterAttack(Monster monster, Hero hero) {
        int d20 = dice.roll(20);
        int totalAttack = d20 + monster.getAttackBonus();

        System.out.println(monster.getName() + " rolls D20: " + d20);
        System.out.println("Total attack: " + totalAttack);

        if (totalAttack >= hero.getArmorClass()) {
            int damage = dice.roll(monster.getDamageDie()) + monster.getDamageBonus();

            hero.takeDamage(damage);

            System.out.println(monster.getName() + " hits " + hero.getName());
            System.out.println("Damage dealt: " + damage);} 
        else {
            System.out.println(monster.getName() + " misses " + hero.getName());
        }
}
}