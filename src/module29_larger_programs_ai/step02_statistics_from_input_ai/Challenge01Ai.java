// AI-Generated
package module29_larger_programs_ai.step02_statistics_from_input_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * At a charity run, the finishing times are typed in, in whole minutes, one per line, until {@code end}. A time must be from 15 to 180 minutes: other times are typing mistakes, and they're skipped. {@code fastest} starts at 180, the slowest valid time, so any valid time can take its place. Fill in the blanks. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Runners: 4
     * Skipped: 2
     * Average: 32.5 min
     * Fastest: 25 min
     * Under 30 min: 50.0%
     * }</pre>
     * Hints
     * 1. The loop stops at the word {@code end}. A time is skipped when it's below 15 <b>or</b> above 180: no time can be both at once.
     * 2. The fastest time is the smallest one, so a time replaces it when it's smaller. The share divides by the number of valid runners, not by every line read.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int runners = 0;
        int skipped = 0;
        int total = 0;
        int fastest = 180;
        int underHalfHour = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("___")) {
                break;
            }
            int time = Integer.valueOf(line);
            if (time < 15 ___ time > 180) {
                skipped++;
                continue;
            }
            runners++;
            total += time;
            if (time ___ fastest) {
                fastest = time;
            }
            if (time < 30) {
                underHalfHour++;
            }
        }
        System.out.println("Runners: " + runners);
        System.out.println("Skipped: " + skipped);
        if (runners == 0) {
            System.out.println("No runners");
        } else {
            System.out.println("Average: " + (double) total / runners + " min");
            System.out.println("Fastest: " + fastest + " min");
            System.out.println("Under 30 min: " + 100.0 * underHalfHour / ___ + "%");
        }
    }
}
