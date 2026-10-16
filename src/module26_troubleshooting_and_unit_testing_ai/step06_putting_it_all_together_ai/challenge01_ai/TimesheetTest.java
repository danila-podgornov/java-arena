// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step06_putting_it_all_together_ai.challenge01_ai;

import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

/**
 * A timesheet reads the hours worked each day, one number per line, until the input ends. Empty lines are skipped, and reading goes on after them. {@code totalHours()} adds up the hours, and {@code overtimeDays()} counts the days of more than 8 hours. {@code TimesheetTest} makes a new Timesheet before each test with {@code @Before}, and has one test.
 * <p>Write tests that give {@code read} its input as a String, and that catch a Timesheet that counts a day of exactly 8 hours as overtime. Two more versions, hidden, have bugs in how they read the lines.
 * Hints
 * 1. Each test reads its own input: {@code this.sheet.read(new Scanner("8\n9\n7\n"));}, and then checks {@code overtimeDays()} or {@code totalHours()}. A day of exactly 8 hours is the limit, and an empty line in the middle of the input is the edge the hidden versions trip on.
 * 2. For example, after reading {@code "8\n9\n7\n"}, {@code assertEquals(1, this.sheet.overtimeDays());}. And after reading {@code "6\n\n10\n"}, {@code assertEquals(16, this.sheet.totalHours());}.
 */
public class TimesheetTest {
    private Timesheet sheet;

    @Before
    public void setUp() {
        this.sheet = new Timesheet();
    }

    @Test
    public void noDaysMeansNoHours() {
        this.sheet.read(new Scanner(""));
        assertEquals(0, this.sheet.totalHours());
    }
}
