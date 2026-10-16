// AI-Generated
package module44_type_parameters_generics_ai.step03_several_type_parameters_and_a_list_of_t_ai.challenge03_ai;

public class Main {
    /**
     * At the finish line of a race, the first three get a place on the podium, and everyone else who finishes is only counted. In {@code Podium.java}, write the class {@code Podium<T>}, which keeps the first three in an {@code ArrayList<T>} (a {@code List<T>} variable that holds an ArrayList is fine too), with:
     * <ul>
     * <li>a constructor {@code Podium()}, which starts with nobody
     * <li>{@code finish(T competitor)}, which records the next one to finish. Only the first three get a place.
     * <li>{@code getPlace(int place)}, which returns the competitor in place 1, 2 or 3, or {@code null} if nobody has that place yet
     * <li>{@code finishers()}, which returns how many have finished in all, on the podium or not
     * </ul>
     * <p>A runner can be given by name, a {@code Podium<String>}, or by the number on their bib, a {@code Podium<Integer>}. The check runs:
     * <pre>{@code
     * Podium<String> sprint = new Podium<>();
     * sprint.finish("Mo");
     * sprint.finish("Lin");
     * sprint.finish("Ada");
     * sprint.finish("Kai");
     * System.out.println(sprint.getPlace(1) + ", " + sprint.getPlace(2) + ", " + sprint.getPlace(3));
     * System.out.println(sprint.finishers() + " finished");
     * Podium<Integer> marathon = new Podium<>();
     * marathon.finish(204);
     * int winner = marathon.getPlace(1);
     * System.out.println("Bib " + winner + " wins");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Mo, Lin, Ada
     * 4 finished
     * Bib 204 wins
     * }</pre>
     * Hints
     * 1. The header is {@code public class Podium<T>}, with {@code private ArrayList<T> places;} and an int that counts the finishers. The constructor makes the list with {@code new ArrayList<>()}.
     * 2. {@code finish} adds the competitor only while the list has fewer than 3, and counts every finisher. Place 1 is at index 0, so {@code getPlace} returns {@code this.places.get(place - 1)}, or {@code null} when the place is past the end of the list.
     */
    public static void main(String[] args) {
        Podium<String> sprint = new Podium<>();
        sprint.finish("Mo");
        sprint.finish("Lin");
        sprint.finish("Ada");
        sprint.finish("Kai");
        System.out.println(sprint.getPlace(1) + ", " + sprint.getPlace(2) + ", " + sprint.getPlace(3));
        System.out.println(sprint.finishers() + " finished");
        Podium<Integer> marathon = new Podium<>();
        marathon.finish(204);
        int winner = marathon.getPlace(1);
        System.out.println("Bib " + winner + " wins");
    }
}
