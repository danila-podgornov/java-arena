// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step04_a_class_of_your_own_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A school play keeps its cast in a list of {@code Role} objects: the play, the character, and the student who plays the character. Two roles are equal when they're the same character in the same play, whoever plays it. (Some names are in more than one play: Shakespeare has a Sebastian in both *Twelfth Night* and *The Tempest*.) In {@code Role.java}, write the method {@code equals}, the way module 23 did. The check runs:
     * <pre>{@code
     * ArrayList<Role> cast = new ArrayList<>();
     * cast.add(new Role("The Tempest", "Ariel", "Noor"));
     * cast.add(new Role("The Tempest", "Miranda", "Liv"));
     * Role understudy = new Role("The Tempest", "Ariel", "Theo");
     * System.out.println(understudy.equals(cast.get(0)));
     * System.out.println(cast.contains(new Role("Twelfth Night", "Viola", "Liv")));
     * System.out.println(cast.indexOf(new Role("The Tempest", "Miranda", "Sam")));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * 1
     * }</pre>
     * Hints
     * 1. Follow the {@code equals} of {@code ClimbingRoute} above, with Role in its place: the header {@code public boolean equals(Object compared)}, the check {@code this == compared}, the {@code instanceof Role} check, and the cast {@code Role other = (Role) compared;}.
     * 2. The last line compares the play and the character, both Strings, with {@code equals}: {@code return this.play.equals(other.play) && this.character.equals(other.character);}. Leave the student out.
     */
    public static void main(String[] args) {
        ArrayList<Role> cast = new ArrayList<>();
        cast.add(new Role("The Tempest", "Ariel", "Noor"));
        cast.add(new Role("The Tempest", "Miranda", "Liv"));
        Role understudy = new Role("The Tempest", "Ariel", "Theo");
        System.out.println(understudy.equals(cast.get(0)));
        System.out.println(cast.contains(new Role("Twelfth Night", "Viola", "Liv")));
        System.out.println(cast.indexOf(new Role("The Tempest", "Miranda", "Sam")));
    }
}
