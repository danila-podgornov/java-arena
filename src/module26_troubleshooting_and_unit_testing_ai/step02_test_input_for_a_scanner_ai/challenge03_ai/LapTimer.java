// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step02_test_input_for_a_scanner_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class LapTimer {
    private ArrayList<Integer> laps;

    public LapTimer() {
        this.laps = new ArrayList<>();
    }

    public void readLaps() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            this.laps.add(Integer.valueOf(scanner.nextLine()));
        }
    }

    public int count() {
        return this.laps.size();
    }

    public int fastest() {
        int fastest = this.laps.get(0);
        for (int lap : this.laps) {
            if (lap < fastest) {
                fastest = lap;
            }
        }
        return fastest;
    }
}
