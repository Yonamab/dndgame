/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dndgame;

/**
 *
 * @author yonamab
 */
public class Dndgame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               Dice dice = new Dice();

        Hero warrior = new Warrior("Aldric");
        Hero mage = new Mage("Merlin");
        Hero archer = new Archer("Robin");
        Hero rogue = new Rogue("Shade");

        System.out.println("Warrior damage: " + warrior.attack(dice));
        System.out.println("Mage damage: " + mage.attack(dice));
        System.out.println("Archer damage: " + archer.attack(dice));
        System.out.println("Rogue damage: " + rogue.attack(dice));

    }
    
}
