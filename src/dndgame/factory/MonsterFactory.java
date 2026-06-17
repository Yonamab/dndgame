/*
 * Project: Roll of Fate
 * Author: Yonathan Abaineh Munshea
 * Course: Object Oriented Programming
 * Instructor: Prof. Salvatore Distefano
 * Date: [Submission Date]
 *
 * Description:
 * This class creates and scales monsters for dungeon rooms.
 */
package dndgame.factory;

import dndgame.core.Dice;
import dndgame.characters.Hero;
import dndgame.characters.Monster;
import dndgame.combat.MonsterPersonality;

public class MonsterFactory {

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

        switch (monsterType) {

            case 1:
                return new Monster(
                        MonsterType.GOBLIN_SCOUT,
                        "Goblin Scout",
                        35 + scalingHP,
                        12 + roomNumber / 3,
                        3 + roomNumber / 4,
                        2 + roomNumber / 5,
                        6,
                        MonsterPersonality.COWARDLY
                );

            case 2:
                return new Monster(
                        MonsterType.SKELETON_KNIGHT,
                        "Skeleton Knight",
                        50 + scalingHP,
                        14 + roomNumber / 3,
                        4 + roomNumber / 4,
                        3 + roomNumber / 5,
                        8,
                        MonsterPersonality.SIMPLE
                );

            case 3:
                return new Monster(
                        MonsterType.CAVE_TROLL,
                        "Cave Troll",
                        75 + scalingHP,
                        13 + roomNumber / 3,
                        5 + roomNumber / 4,
                        4 + roomNumber / 5,
                        10,
                        MonsterPersonality.AGGRESSIVE
                );

            case 4:
                return new Monster(
                        MonsterType.DARK_SORCERER,
                        "Dark Sorcerer",
                        55 + scalingHP,
                        15 + roomNumber / 3,
                        5 + roomNumber / 4,
                        4 + roomNumber / 5,
                        8,
                        MonsterPersonality.STRATEGIC
                );

            default:
                return new Monster(
                        MonsterType.DIRE_WOLF_ALPHA,
                        "Dire Wolf Alpha",
                        60 + scalingHP,
                        14 + roomNumber / 3,
                        6 + roomNumber / 4,
                        3 + roomNumber / 5,
                        8,
                        MonsterPersonality.AGGRESSIVE
                );
        }
    }

    public static Monster createBoss(Hero hero) {

        return new Monster(
                MonsterType.ANCIENT_SHADOW_DRAGON,
                "Ancient Shadow Dragon",
                180 + hero.getLevel() * 20,
                18,
                7 + hero.getLevel() / 2,
                6 + hero.getLevel(),
                12,
                MonsterPersonality.STRATEGIC
        );
    }
}