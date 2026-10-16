// AI-Generated
package module43_writing_files_ai.step02_adding_to_a_file_ai;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Challenge03Ai {
    /**
     * A sleep tracker adds a line to its log every morning. Write the method {@code logNight(String fileName, String day, int hours)}, which adds the line {@code day: hours h}, such as {@code Tue: 7 h}, at the end of the file, keeping what the file holds. When there's no such file yet, it's created. Use a FileWriter that appends.
     * <p>Nobody sleeps less than 0 or more than 24 hours in a night. For such hours, {@code logNight} throws an IllegalArgumentException with the message {@code impossible: } and the hours and {@code  hours}, such as {@code impossible: 30 hours}, and writes nothing.
     * <p>The check calls {@code logNight} for Tuesday (7 hours) and Wednesday (6 hours) on the file shown below, which has Monday's line, and after it {@code sleep.txt} should hold: see the expected output below.
     * Expected output
     * <pre>{@code
     * Mon: 8 h
     * Tue: 7 h
     * Wed: 6 h
     * }</pre>
     * Hints
     * 1. Check the hours first, and {@code throw new IllegalArgumentException("impossible: " + hours + " hours")} before the file is opened. The header ends with {@code throws Exception}, for the FileWriter.
     * 2. Then {@code PrintWriter writer = new PrintWriter(new FileWriter(fileName, true));}, one {@code println} with the day, {@code : }, the hours and {@code  h}, and {@code writer.close()}.
     */
    public static void main(String[] args) throws Exception {
        logNight("sleep.txt", "Tue", 7);
        logNight("sleep.txt", "Wed", 6);
    }

    // Write the method logNight here.
}
