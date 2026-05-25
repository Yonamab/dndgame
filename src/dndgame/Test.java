package dndgame;

public class Test {
    public static void main(String[] args) {

        Hero hero = new Warrior("Aldric");

        for (int i = 1; i <= 5; i++) {
            Monster monster = MonsterFactory.createMonster(i, hero);

            System.out.println("Room " + i);
            System.out.println("Monster: " + monster.getName());
            System.out.println("HP: " + monster.getCurrentHealth());
            System.out.println("Personality: " + monster.getPersonality());
            System.out.println();
        }

        Monster boss = MonsterFactory.createBoss(hero);
        System.out.println("Boss: " + boss.getName());
        System.out.println("Boss HP: " + boss.getCurrentHealth());
    }
}