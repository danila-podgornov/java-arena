// AI-Generated
package module24_lists_inside_objects_ai.step03_methods_that_go_through_the_list_ai.challenge01_ai;

public class Main {
    /**
     * A garden keeps a list of the plants that grow in it. {@code Garden.java} has the list and the method {@code plant(String name)}. Write two more methods in it:
     * <ul>
     * <li>{@code print()} prints each plant on a line of its own, starting with {@code * }.
     * <li>{@code grows(String name)} returns {@code true} when that plant is in the garden.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Garden garden = new Garden();
     * garden.plant("rose");
     * garden.plant("mint");
     * garden.plant("fern");
     * garden.print();
     * System.out.println(garden.grows("mint"));
     * System.out.println(garden.grows("oak"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * * rose
     * * mint
     * * fern
     * true
     * false
     * }</pre>
     * Hints
     * 1. {@code print} is a for-each loop over the garden's own list, {@code this.plants}. {@code grows} can pass its question on to one of the list's own methods.
     * 2. {@code for (String plant : this.plants) { System.out.println("* " + plant); }} prints the plants, and {@code return this.plants.contains(name);} answers {@code grows}.
     */
    public static void main(String[] args) {
        Garden garden = new Garden();
        garden.plant("rose");
        garden.plant("mint");
        garden.plant("fern");
        garden.print();
        System.out.println(garden.grows("mint"));
        System.out.println(garden.grows("oak"));
    }
}
