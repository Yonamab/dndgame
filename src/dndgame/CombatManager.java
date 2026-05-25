/**
 * Project: Roll of Fate
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
    private EnemyAI enemyAI;
    private PlayerBehaviorTracker behaviorTracker;
    private CriticalHitRule criticalHitRule;
    private int lastD20Roll;
    private int lastDamageRoll;

    public CombatManager() {
        dice = new Dice();
        enemyAI = new EnemyAI();
        behaviorTracker = new PlayerBehaviorTracker();
        criticalHitRule = new CriticalHitRule(2);
    }

    public void heroAttack(Hero hero, Monster monster) {
        behaviorTracker.recordAttack();
        
        int d20 = dice.roll(20);
        lastD20Roll = d20;
        int totalAttack = d20 + hero.getAttackBonus() + hero.getTemporaryAttackBonus();

        System.out.println(hero.getName() + " rolls D20: " + d20);
        System.out.println("Total attack: " + totalAttack);

        if (totalAttack >= monster.getArmorClass()) {
            
            int damage = hero.attack(dice);
            damage += hero.getTemporaryDamageBonus();
            lastDamageRoll = damage;

            monster.takeDamage(damage);

            System.out.println(hero.getName() + " hits " + monster.getName());
            System.out.println("Damage dealt: " + damage);} 
        else {
            System.out.println(hero.getName() + " misses " + monster.getName());
        }
    }
    
    public void heroSpecialAttack(Hero hero, Monster monster) {

        if (!monster.isAlive()) {
            return;
        }

        Dice dice = new Dice();

        int d20 = dice.roll(20);
        lastD20Roll = d20;

        int totalAttack =
                d20
                + hero.getAttackBonus()
                + hero.getTemporaryAttackBonus();

        System.out.println(hero.getName() + " rolls D20: " + d20);

        if (d20 == 20 || totalAttack >= monster.getArmorClass()) {

            int damage = hero.specialAttack(dice);
            lastDamageRoll = damage;

            if (d20 == 20) {

                damage *= 2;

                System.out.println(
                        "Critical special attack!"
                );
            }

            monster.takeDamage(damage);

            System.out.println(
                    hero.getName()
                    + " dealt "
                    + damage
                    + " special damage."
            );

        } else {

            System.out.println(
                    hero.getName()
                    + " missed the special attack on "
                    + monster.getName()
                    + "."
            );
        }
    }

    public void monsterAttack(Monster monster, Hero hero) {
        if (!monster.isAlive()) {
            System.out.println(monster.getName() + " cannot attack because it is defeated.");
            return;
        }

        EnemyAction action = enemyAI.chooseAction(monster, hero, behaviorTracker);

        System.out.println(monster.getName() + " chooses: " + action);

        if (action == EnemyAction.DEFEND) {
            System.out.println(monster.getName() + " defends and waits for a better moment.");
            return;
        }

        int d20 = dice.roll(20);
        lastD20Roll = d20;
        int totalAttack = d20 + monster.getAttackBonus();
        

        System.out.println(monster.getName() + " rolls D20: " + d20);
        System.out.println("Total attack: " + totalAttack);

        if (d20 == 20 || totalAttack >= hero.getTotalArmorClass()) {

            int damage = dice.roll(monster.getDamageDie()) + monster.getDamageBonus();

            if (action == EnemyAction.SPECIAL) {
                int specialDamage = dice.roll(6);
                damage += specialDamage;

                System.out.println(monster.getName()
                        + " uses a special attack and adds "
                        + specialDamage
                        + " damage.");
            }

            if (monster.getName().equals("Ancient Shadow Dragon")) {
                int dragonDamage = dice.roll(12);
                damage += dragonDamage;

                System.out.println("The dragon breathes shadow fire for "
                        + dragonDamage
                        + " extra damage.");
            }

            if (d20 == 20) {
                damage = criticalHitRule.applyCritical(damage);
                System.out.println("Enemy critical hit! Damage doubled.");
            }

            hero.takeDamage(damage);
            lastDamageRoll = damage;

            System.out.println(monster.getName()
                    + " hits "
                    + hero.getName());

            System.out.println("Damage dealt: " + damage);

        } 
        else {
            System.out.println(monster.getName()
                    + " misses "
                    + hero.getName());
        }
    }
    
    public PlayerBehaviorTracker getBehaviorTracker() {
        
        return behaviorTracker;
    }
    
    public void recordPotionUse() {
        
        behaviorTracker.recordPotionUse();
    }
    
    public CriticalHitRule getCriticalHitRule() {
        
        return criticalHitRule;
    }

    public void setCriticalHitRule(CriticalHitRule criticalHitRule) {

        this.criticalHitRule = criticalHitRule;
    }
    
    public int getLastD20Roll() {
    return lastD20Roll;
    }

    public int getLastDamageRoll() {
        return lastDamageRoll;
    }
}