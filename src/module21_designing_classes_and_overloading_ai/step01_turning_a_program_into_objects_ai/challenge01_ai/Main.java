// AI-Generated
package module21_designing_classes_and_overloading_ai.step01_turning_a_program_into_objects_ai.challenge01_ai;

public class Main {
    /**
     * In a game, a hero starts with 100 health. A hit takes health away, but never below 0, and healing gives health back, but never above 100. {@code Main.java} is ready and uses a {@code Hero} object. Write the class in {@code Hero.java}:
     * <ul>
     * <li>{@code Hero(String name)} makes a hero with 100 health.
     * <li>{@code hit(int damage)} takes {@code damage} off the health. The health doesn't go below 0.
     * <li>{@code heal(int amount)} adds {@code amount} to the health. The health doesn't go above 100.
     * <li>{@code toString()} returns the name and the health, as in the output below.
     * </ul>
     * <p>The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Aria, health 90
     * Aria, health 100
     * Aria, health 0
     * }</pre>
     * Hints
     * 1. A hero must remember two things: {@code private String name;} and {@code private int health;}. The constructor stores the name and sets the health to 100.
     * 2. {@code hit} subtracts and then sets the health back to 0 if it went below 0. {@code heal} adds and then sets it back to 100 if it went above 100. {@code toString} returns {@code this.name + ", health " + this.health}.
     */
    public static void main(String[] args) {
        Hero hero = new Hero("Aria");
        hero.hit(30);
        hero.heal(20);
        System.out.println(hero);
        hero.heal(50);
        System.out.println(hero);
        hero.hit(120);
        System.out.println(hero);
    }
}
