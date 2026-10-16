// AI-Generated
package module21_designing_classes_and_overloading_ai.step01_turning_a_program_into_objects_ai.challenge03_ai;

public class Hero {
    private String name;
    private int health;

    public Hero(String name) {
        this.name = name;
        this.health = 100;
    }

    public void hit(int damage) {
        this.health = this.health - damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void heal(int amount) {
        this.health = this.health + amount;
        if (this.health > 100) {
            this.health = 100;
        }
    }

    public String toString() {
        return this.name + ", health " + this.health;
    }
}
