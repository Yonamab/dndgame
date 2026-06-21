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
package dndgame.factory;

import dndgame.core.Dice;
import dndgame.characters.Hero;
import dndgame.characters.Monster;
import dndgame.combat.MonsterPersonality;
import dndgame.combat.StandardMonsterAttackBehavior;
import dndgame.combat.DragonAttackBehavior;

public class MonsterFactory {

    private static int boost(int value) {
        return (int) Math.round(value * 1.10);
    }

    public static Monster createMonster(int roomNumber, Hero hero) {

        Dice dice = new Dice();

        int playerPower =
                hero.getLevel()
                + hero.getEquippedWeapon().getDamageBonus()
                + hero.getArmorBonus();

        int scalingHP =
                roomNumber * 10
                + hero.getLevel() * 6
                + playerPower * 2;

        int monsterType = dice.roll(5);
        
        Monster monster = null;

        switch (monsterType) {

            case 1:
                monster = new Monster(
                        MonsterType.GOBLIN_SCOUT,
                        "Goblin Scout",
                        boost(35 + scalingHP),
                        boost(12 + roomNumber / 3),
                        boost(3 + roomNumber / 4),
                        boost(2 + roomNumber / 5),
                        6,
                        MonsterPersonality.COWARDLY
                );
                break;

            case 2:
                monster = new Monster(
                        MonsterType.SKELETON_KNIGHT,
                        "Skeleton Knight",
                        boost(50 + scalingHP),
                        boost(14 + roomNumber / 3),
                        boost(4 + roomNumber / 4),
                        boost(3 + roomNumber / 5),
                        8,
                        MonsterPersonality.SIMPLE
                );
                break;

            case 3:
                monster = new Monster(
                        MonsterType.CAVE_TROLL,
                        "Cave Troll",
                        boost(75 + scalingHP),
                        boost(13 + roomNumber / 3),
                        boost(5 + roomNumber / 4),
                        boost(4 + roomNumber / 5),
                        10,
                        MonsterPersonality.AGGRESSIVE
                );
                break;

            case 4:
                monster = new Monster(
                        MonsterType.DARK_SORCERER,
                        "Dark Sorcerer",
                        boost(55 + scalingHP),
                        boost(15 + roomNumber / 3),
                        boost(5 + roomNumber / 4),
                        boost(4 + roomNumber / 5),
                        8,
                        MonsterPersonality.STRATEGIC
                );
                break;

            default:
                monster = new Monster(
                        MonsterType.DIRE_WOLF_ALPHA,
                        "Dire Wolf Alpha",
                        boost(60 + scalingHP),
                        boost(14 + roomNumber / 3),
                        boost(6 + roomNumber / 4),
                        boost(3 + roomNumber / 5),
                        8,
                        MonsterPersonality.AGGRESSIVE
                );
                break;
        }
        
        monster.setAttackBehavior(new StandardMonsterAttackBehavior());
        return monster;
    }

    public static Monster createBoss(Hero hero) {

        Monster boss = new Monster(
                MonsterType.ANCIENT_SHADOW_DRAGON,
                "Ancient Shadow Dragon",
                boost(180 + hero.getLevel() * 20),
                boost(18),
                boost(7 + hero.getLevel() / 2),
                boost(6 + hero.getLevel()),
                12,
                MonsterPersonality.STRATEGIC
        );
        
        boss.setAttackBehavior(new DragonAttackBehavior());
        return boss;
    }
}