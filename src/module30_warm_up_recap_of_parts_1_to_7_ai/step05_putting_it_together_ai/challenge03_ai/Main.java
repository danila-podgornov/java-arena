// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step05_putting_it_together_ai.challenge03_ai;

public class Main {
    /**
     * The school play of step 4 keeps its cast in a {@code Cast} object. {@code Role.java} is step 4's class with its {@code equals}: two roles are equal when they're the same character in the same play, whoever plays it. Role has no getters for the play or the character, so a search for a role goes through {@code equals}. In {@code Cast.java}, replace the placeholders:
     * <ul>
     * <li>{@code add(Role role)} adds the role to the list and returns {@code true}. When an equal role is already in the list, it changes nothing and returns {@code false}.
     * <li>{@code recast(Role role)} gives a role that's already in the list to another student: it puts the role it gets in the place of the equal role, at the same index, and returns {@code true}. When no equal role is in the list, it changes nothing and returns {@code false}.
     * <li>{@code studentFor(String play, String character)} returns the student who plays that character in that play, or {@code null} when nobody does.
     * </ul>
     * <p>Use the list's {@code contains} and {@code indexOf}, which compare with Role's {@code equals}. Cast doesn't print anything. {@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * true
     * false
     * Theo null
     * [Ariel in The Tempest: Theo, Miranda in The Tempest: Liv]
     * }</pre>
     * Hints
     * 1. {@code add} is the Gym's {@code add} from the lesson: {@code contains(role)} first, and only then {@code add}. In {@code recast}, {@code indexOf(role)} finds the equal role, since {@code equals} ignores the student, and {@code this.roles.set(index, role)} puts the new one in its place (module 14).
     * 2. {@code studentFor} needs a role to search with, like the Gym's {@code find}: {@code new Role(play, character, "")}. The student doesn't matter to {@code equals}, so any text will do. When {@code indexOf} gives -1, return {@code null}, and otherwise {@code get(index).getStudent()}.
     */
    public static void main(String[] args) {
        Cast cast = new Cast();
        System.out.println(cast.add(new Role("The Tempest", "Ariel", "Noor")));
        System.out.println(cast.add(new Role("The Tempest", "Miranda", "Liv")));
        System.out.println(cast.add(new Role("The Tempest", "Ariel", "Theo")));
        System.out.println(cast.recast(new Role("The Tempest", "Ariel", "Theo")));
        System.out.println(cast.recast(new Role("Macbeth", "Banquo", "Eli")));
        System.out.println(cast.studentFor("The Tempest", "Ariel") + " " + cast.studentFor("The Tempest", "Prospero"));
        System.out.println(cast.roles());
    }
}
