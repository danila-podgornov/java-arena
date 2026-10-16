// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step06_a_class_that_remembers_ai.challenge01_ai;

public class Main {
    /**
     * A {@code RainLog} collects the rainfall of each day, in millimeters. Write its methods: {@code add(int mm)} records one day's rain, {@code dryDays()} returns how many days had no rain at all, and {@code wettest()} returns the most rain on a single day (0 before any rain). The instance variables are ready, and {@code add} keeps both of them up to date. The check records 4, 0, 11 and 0 mm: see the expected output below.
     * Expected output
     * {@code 2 dry days, wettest 11 mm}
     * Hints
     * 1. {@code add} is {@code void}. It has two {@code if}s: one counts the day when {@code mm == 0}, the other stores {@code mm} in {@code this.wettest} when it's bigger.
     * 2. {@code dryDays()} and {@code wettest()} return the instance variables: {@code return this.dryDays;} and {@code return this.wettest;}
     */
    public static void main(String[] args) {
        RainLog log = new RainLog();
        log.add(4);
        log.add(0);
        log.add(11);
        log.add(0);
        System.out.println(log.dryDays() + " dry days, wettest " + log.wettest() + " mm");
    }
}
