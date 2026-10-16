// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step02_a_list_of_your_own_ai.challenge03_ai;

public class Main {
    /**
     * A science center's turnstile counts the people who come in during each hour. {@code TurnstileLog.java} keeps the counts in an {@code int} array that should grow, but the program crashes with an ArrayIndexOutOfBoundsException as soon as the third hour's count is added. There are two mistakes in {@code TurnstileLog.java}, one in {@code add} and one in {@code grow}. Fix them. The check runs:
     * <pre>{@code
     * TurnstileLog log = new TurnstileLog();
     * int[] hours = {14, 3, 22, 9, 17};
     * for (int people : hours) {
     *     log.add(people);
     * }
     * System.out.println(log.size() + " hours, " + log.total() + " people");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 5 hours, 65 people}
     * Hints
     * 1. With 2 values in an array of length 2, {@code this.size > this.values.length} is {@code 2 > 2}, which is false, so {@code grow} isn't called, and the value goes to index 2. The array is full exactly when the two are equal.
     * 2. {@code grow} fills a new array, but {@code this.values} still refers to the old one when the method ends. Add {@code this.values = bigger;} after the loop.
     */
    public static void main(String[] args) {
        TurnstileLog log = new TurnstileLog();
        int[] hours = {14, 3, 22, 9, 17};
        for (int people : hours) {
            log.add(people);
        }
        System.out.println(log.size() + " hours, " + log.total() + " people");
    }
}
