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

        System.out.println("D20 roll: " + dice.roll(20));
        System.out.println("D6 roll: " + dice.roll(6));
        System.out.println("D8 roll: " + dice.roll(8));

        try {
            System.out.println(dice.roll(0));
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
    
}
