// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step06_putting_it_all_together_ai.challenge01_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Timesheet {
    private ArrayList<Integer> days;

    public Timesheet() {
        this.days = new ArrayList<>();
    }

    public void read(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                this.days.add(Integer.valueOf(line));
            }
        }
    }

    public int totalHours() {
        int total = 0;
        for (int hours : this.days) {
            total += hours;
        }
        return total;
    }

    public int overtimeDays() {
        int count = 0;
        for (int hours : this.days) {
            if (hours > 8) {
                count++;
            }
        }
        return count;
    }
}
