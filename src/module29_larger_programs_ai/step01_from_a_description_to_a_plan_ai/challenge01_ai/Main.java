// AI-Generated
package module29_larger_programs_ai.step01_from_a_description_to_a_plan_ai.challenge01_ai;

public class Main {
    /**
     * Friends plan a movie marathon: films watched one after another. The plan is the same as for the game night: {@code Film} for the data (ready), {@code Marathon} for the logic, and {@code main} for the input (the next challenge). {@code Marathon.java} has placeholders that compile but give wrong answers. Write its four methods:
     * <ul>
     * <li>{@code add(Film film)} adds the film to the list.
     * <li>{@code count()} returns how many films there are.
     * <li>{@code totalMinutes()} returns the films' minutes added up.
     * <li>{@code shortest()} returns the shortest film, or {@code null} when there are no films. If two films are equally short, it returns the one added first.
     * </ul>
     * <p>Marathon doesn't print anything. {@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 0 0 null
     * 3 315
     * Paper Moons (95 min)
     * }</pre>
     * Hints
     * 1. {@code add} puts the film in {@code this.films}, and {@code count} is the list's {@code size()}. {@code totalMinutes} adds up {@code film.getMinutes()} in a for-each loop.
     * 2. For {@code shortest}, start with {@code Film shortest = null;} and go through the list. Replace it when it's still {@code null}, or when the film has fewer minutes ({@code <}, so that the first of two equal films stays). Return it after the loop.
     */
    public static void main(String[] args) {
        Marathon marathon = new Marathon();
        System.out.println(marathon.count() + " " + marathon.totalMinutes() + " " + marathon.shortest());
        marathon.add(new Film("Night Train", 118));
        marathon.add(new Film("Paper Moons", 95));
        marathon.add(new Film("Summer Rain", 102));
        System.out.println(marathon.count() + " " + marathon.totalMinutes());
        System.out.println(marathon.shortest());
    }
}
