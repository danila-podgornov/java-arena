// AI-Generated
package module51_data_visualization_ai.step07_honest_charts_ai.challenge02_ai;

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
}
