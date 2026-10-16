// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step05_test_driven_development_ai.challenge03_ai;

import java.util.ArrayList;

/**
 * A carpool shares a car to work, and keeps the names of its riders, up to the number of seats. {@code CarpoolTest} is written, and your job is to write {@code Carpool} so its tests pass, one failing test at a time:
 * <ul>
 * <li>{@code new Carpool(seats)} makes an empty carpool with that many seats.
 * <li>{@code join(String name)} adds the rider and returns {@code true}. It returns {@code false} and adds nobody when every seat is taken, or when the same name is in the carpool already.
 * <li>{@code leave(String name)} takes the rider out of the carpool, if they're in it.
 * <li>{@code riders()} returns how many riders there are, and {@code isFull()} whether every seat is taken.
 * </ul>
 * <p>The checks run the tests of {@code CarpoolTest} as they are given here (changing them won't help), and more tests of their own.
 * Hints
 * 1. The carpool needs two instance variables: the number of seats, and a list of names made in the constructor, {@code this.names = new ArrayList<>();}. {@code riders()} is the list's size, and {@code isFull()} compares it with the seats.
 * 2. In {@code join}, turn the rider away first: {@code if (this.isFull() || this.names.contains(name)) { return false; }}, then add the name and return {@code true}. The list's {@code contains} and {@code remove} compare names with {@code equals}, so {@code leave} is just {@code this.names.remove(name);}.
 */
public class Carpool {
    public Carpool(int seats) {
    }

    public boolean join(String name) {
        return false;
    }

    public void leave(String name) {
    }

    public int riders() {
        return 0;
    }

    public boolean isFull() {
        return false;
    }
}
