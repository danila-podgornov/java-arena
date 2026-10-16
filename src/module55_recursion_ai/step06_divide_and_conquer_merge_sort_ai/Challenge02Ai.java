// AI-Generated
package module55_recursion_ai.step06_divide_and_conquer_merge_sort_ai;

import java.util.Arrays;

public class Challenge02Ai {
    /**
     * A paper plane contest records how far each plane flies, in centimeters, in the order the planes are thrown. Write {@code mergeSort(int[] values)}, which returns a new sorted array of the distances, with merge sort: an array of at most one value is returned as it is; any other array is split in two with {@code Arrays.copyOfRange}, each half is sorted with {@code mergeSort}, and the sorted halves are merged with {@code merge}, which is given. Don't use {@code Arrays.sort} or {@code Collections.sort}. The check runs:
     * <pre>{@code
     * int[] distances = {1240, 875, 1630, 875, 1105, 690};
     * System.out.println(Arrays.toString(mergeSort(distances)));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code [690, 875, 875, 1105, 1240, 1630]}
     * Hints
     * 1. The base case: {@code if (values.length <= 1) { return values; }}. Otherwise {@code int middle = values.length / 2;}, and the halves are {@code Arrays.copyOfRange(values, 0, middle)} and {@code Arrays.copyOfRange(values, middle, values.length)}.
     * 2. Sort each half with {@code mergeSort}, then {@code return merge(left, right);}
     */
    public static void main(String[] args) {
        int[] distances = {1240, 875, 1630, 875, 1105, 690};
        System.out.println(Arrays.toString(mergeSort(distances)));
    }

    public static int[] mergeSort(int[] values) {
        return values;
    }

    public static int[] merge(int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }
        while (i < first.length) {
            merged[k] = first[i];
            i++;
            k++;
        }
        while (j < second.length) {
            merged[k] = second[j];
            j++;
            k++;
        }
        return merged;
    }
}
