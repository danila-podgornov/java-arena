// AI-Generated
package module37_streams_and_lambdas_ai.step07_reduce_and_intstream_ai;

import java.util.stream.IntStream;

public class Challenge02Ai {
    /**
     * A cinema row has {@code seats} seats, numbered from 1. Fill in the blank so that the program prints a label for each seat of row C, the last one included. For the program as it is, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * C1
     * C2
     * C3
     * C4
     * C5
     * C6
     * }</pre>
     * Hints
     * 1. {@code range(1, seats)} would stop at 5: its end isn't included.
     * 2. The kind of range that includes its end is {@code rangeClosed}.
     */
    public static void main(String[] args) {
        int seats = 6;
        IntStream.___(1, seats)
                .forEach(seat -> System.out.println("C" + seat));
    }
}
