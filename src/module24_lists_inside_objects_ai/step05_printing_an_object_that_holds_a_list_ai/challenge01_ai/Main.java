// AI-Generated
package module24_lists_inside_objects_ai.step05_printing_an_object_that_holds_a_list_ai.challenge01_ai;

public class Main {
    /**
     * {@code Aquarium.java} has a name and a list of fish, and {@code Fish.java} is ready (its toString gives, for example, {@code Finn the clownfish}). Write toString for Aquarium. The first line is the aquarium's name and the number of fish, like {@code Reef tank: 2 fish}, and then each fish comes on a line of its own. There's no line break at the end of the text: {@code println} adds that. An aquarium with no fish is just {@code Reef tank: empty}. The check runs:
     * <pre>{@code
     * Aquarium tank = new Aquarium("Reef tank");
     * System.out.println(tank);
     * tank.add(new Fish("Finn", "clownfish"));
     * tank.add(new Fish("Coral", "blue tang"));
     * System.out.println(tank);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Reef tank: empty
     * Reef tank: 2 fish
     * Finn the clownfish
     * Coral the blue tang
     * }</pre>
     * Hints
     * 1. Check for the empty aquarium first: {@code if (this.fish.isEmpty()) { return this.name + ": empty"; }}.
     * 2. Then start with the first line, {@code String text = this.name + ": " + this.fish.size() + " fish";}, add {@code "\n"} and a fish in each round of a loop over {@code this.fish}, and return {@code text} after the loop.
     */
    public static void main(String[] args) {
        Aquarium tank = new Aquarium("Reef tank");
        System.out.println(tank);
        tank.add(new Fish("Finn", "clownfish"));
        tank.add(new Fish("Coral", "blue tang"));
        System.out.println(tank);
    }
}
