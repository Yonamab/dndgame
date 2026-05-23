package dndgame;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Hero hero = new Warrior("Aldric");
        Game game = new Game(hero);

        System.out.println("Boss unlocked: " + game.isBossUnlocked());

        game.getCurrentRoom().clearRoom();
        game.goToNextRoom();

        game.getCurrentRoom().clearRoom();
        game.goToNextRoom();

        game.getCurrentRoom().clearRoom();
        game.goToNextRoom();

        game.getCurrentRoom().clearRoom();
        game.goToNextRoom();

        System.out.println("Boss unlocked: " + game.isBossUnlocked());

        game.getCurrentRoom().clearRoom();
        game.startBossFight();

        System.out.println("Current monster: " + game.getCurrentRoom().getMonster().getName());
    }
    
}
