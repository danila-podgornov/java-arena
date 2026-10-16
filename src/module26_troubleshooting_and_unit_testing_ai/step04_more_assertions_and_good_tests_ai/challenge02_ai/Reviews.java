// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step04_more_assertions_and_good_tests_ai.challenge02_ai;

import java.util.ArrayList;

public class Reviews {
    private ArrayList<Integer> stars;

    public Reviews() {
        this.stars = new ArrayList<>();
    }

    public void add(int stars) {
        if (stars >= 1 && stars <= 5) {
            this.stars.add(stars);
        }
    }

    public int count() {
        return this.stars.size();
    }

    public double average() {
        if (this.stars.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int star : this.stars) {
            sum += star;
        }
        return (double) sum / this.stars.size();
    }
}
