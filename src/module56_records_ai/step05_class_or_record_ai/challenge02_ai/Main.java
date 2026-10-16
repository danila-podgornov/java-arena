// AI-Generated
package module56_records_ai.step05_class_or_record_ai.challenge02_ai;

public class Main {
    /**
     * A cable car's gondola takes riders up a mountain, each with a name and a weight in kilos. A rider's details never change; who is in the gondola changes all day. Write both, choosing a record for one and a class for the other:
     * <ul>
     * <li>{@code Rider}, with the components {@code name} (a String) and {@code kilos} (an int);
     * <li>{@code Gondola}, with a constructor {@code Gondola(int maxKilos)} (the most it can carry), and the methods:
     * <li>{@code board(Rider rider)}, which lets the rider in and returns {@code true}, unless the same rider is already in the gondola or the load would go over {@code maxKilos}; then nobody gets in and it returns {@code false};
     * <li>{@code totalKilos()}, the weight of everyone in the gondola;
     * <li>{@code leave(String name)}, which lets out the rider with that name and returns {@code true}, or returns {@code false} when there's no such rider in the gondola.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Gondola gondola = new Gondola(300);
     * System.out.println(gondola.board(new Rider("Anni", 70)));
     * System.out.println(gondola.board(new Rider("Anni", 70)));
     * System.out.println(gondola.board(new Rider("Bruno", 95)));
     * System.out.println(gondola.board(new Rider("Carl", 140)));
     * System.out.println(gondola.totalKilos() + " kilos");
     * System.out.println(gondola.leave("Anni") + " " + gondola.leave("Zoe"));
     * System.out.println(gondola.totalKilos() + " kilos");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * true
     * false
     * 165 kilos
     * true false
     * 95 kilos
     * }</pre>
     * Hints
     * 1. Look back at the task's second sentence. Which of the two changes during the day, and which is just a few values that never change? Values that never change fit a record.
     * 2. Rider is a record, {@code public record Rider(String name, int kilos) { }}, and Gondola is a class with an {@code ArrayList<Rider>} and the most it can carry. In {@code board}, {@code contains} finds an equal rider because records have {@code equals}. In {@code leave}, look for the rider whose {@code name()} equals the name, remove them and return {@code true} right away (returning ends the loop before the list's change can disturb it).
     */
    public static void main(String[] args) {
        Gondola gondola = new Gondola(300);
        System.out.println(gondola.board(new Rider("Anni", 70)));
        System.out.println(gondola.board(new Rider("Anni", 70)));
        System.out.println(gondola.board(new Rider("Bruno", 95)));
        System.out.println(gondola.board(new Rider("Carl", 140)));
        System.out.println(gondola.totalKilos() + " kilos");
        System.out.println(gondola.leave("Anni") + " " + gondola.leave("Zoe"));
        System.out.println(gondola.totalKilos() + " kilos");
    }
}
