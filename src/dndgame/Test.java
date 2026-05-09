/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dndgame;

/**
 *
 * @author yonamab
 */
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
