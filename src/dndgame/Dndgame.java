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
               Hero hero = new Warrior("Aldric");

        hero.getInventory().addItem(new Potion());
        hero.getInventory().addItem(new Potion());

        System.out.println("Inventory before using potion:");
        hero.getInventory().showItems();

        hero.takeDamage(50);
        System.out.println("HP after damage: " + hero.getCurrentHealth());

        Potion potion = hero.getInventory().getPotion();

        if (potion != null) {
            potion.use(hero);
            hero.getInventory().removeItem(potion);
        } else {
            System.out.println("No potion available.");
        }

        System.out.println("HP after potion: " + hero.getCurrentHealth());

        System.out.println("Inventory after using potion:");
        hero.getInventory().showItems();
    

    }
    
}
