package dndgame;

public class Character {

    private String name;
    private int maxHealth;
    private int currentHealth;
    private int armorClass;

    public Character(String name, int maxHealth, int armorClass) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.armorClass = armorClass;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }
}