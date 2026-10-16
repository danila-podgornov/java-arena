// AI-Generated
package module36_polymorphism_ai.step02_instanceof_and_casts_ai.challenge03_ai;

public abstract class Enemy {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void heal(int amount) {
        this.health += amount;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.health + ")";
    }
}
