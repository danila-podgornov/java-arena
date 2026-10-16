// AI-Generated
package module29_larger_programs_ai.step02_statistics_from_input_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * A phone's screen-time log reads the minutes the screen was on each day, one number per line, until {@code end}. The rule: a day has 1440 minutes, so a value must be from 0 to 1440, and other lines are skipped (a skipped line isn't a day at all). The last line of the report is the longest run of days in a row with more than 2 hours (120 minutes). The program has two bugs. For the input shown, it prints {@code Days: 5}, {@code Average: 484.0 min}, {@code Most: 2000 min} and {@code Days in a row over 2 hours: 3}. Fix it, so that it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Days: 4
     * Average: 105.25 min
     * Most: 150 min
     * Days in a row over 2 hours: 2
     * }</pre>
     * Hints
     * 1. 2000 was counted as a day, and it even made the run of long days one day longer. Can a number be below 0 <b>and</b> above 1440 at the same time? The rule's {@code if} must be true when either one holds.
     * 2. {@code total / days} divides two {@code int} values, so the decimals are gone before the result is stored in the double. Cast first: {@code (double) total / days}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = 0;
        int total = 0;
        int most = 0;
        int run = 0;
        int longestRun = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            int minutes = Integer.valueOf(line);
            if (minutes < 0 && minutes > 1440) {
                continue;
            }
            days++;
            total += minutes;
            if (minutes > most) {
                most = minutes;
            }
            if (minutes > 120) {
                run++;
                if (run > longestRun) {
                    longestRun = run;
                }
            } else {
                run = 0;
            }
        }
        if (days == 0) {
            System.out.println("No days logged");
        } else {
            double average = total / days;
            System.out.println("Days: " + days);
            System.out.println("Average: " + average + " min");
            System.out.println("Most: " + most + " min");
            System.out.println("Days in a row over 2 hours: " + longestRun);
        }
    }
}
