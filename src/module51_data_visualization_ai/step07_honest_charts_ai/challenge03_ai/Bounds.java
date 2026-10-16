// AI-Generated
package module51_data_visualization_ai.step07_honest_charts_ai.challenge03_ai;

import java.util.List;

public class Bounds {

    public static int upperBound(List<Integer> values, int tick) {
        int max = 0;
        for (int value : values) {
            max = Math.max(max, value);
        }
        int upper = tick;
        while (upper < max) {
            upper += tick;
        }
        return upper;
    }

    public static int niceTick(int max) {
        int power = 1;
        while (true) {
            if (power * 10 >= max) {
                return power;
            }
            if (power * 2 * 10 >= max) {
                return power * 2;
            }
            if (power * 5 * 10 >= max) {
                return power * 5;
            }
            power = power * 10;
        }
    }
}
