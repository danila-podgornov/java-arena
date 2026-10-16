// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step05_test_driven_development_ai.challenge01_ai;

/**
 * A coffee machine has a water tank that holds a number of milliliters. {@code CoffeeMachineTest} is written already, and your job is to make its tests pass. {@code CoffeeMachine.java} has empty methods, so the tests compile, and three of the four fail at first. {@code cannotUseMoreThanIsLeft} passes by luck, because {@code left()} returns 0 for now. It starts failing once {@code brew} takes water without checking how much is left: that's the mistake it's there to catch. Run the tests, pick one failing test, write just enough code for it, and run them again, until all of them pass:
 * <ul>
 * <li>A new machine's tank is full: {@code left()} returns its capacity.
 * <li>{@code brew(int ml)} uses that much water, but never more than is left.
 * <li>{@code refill()} fills the tank back up.
 * </ul>
 * <p>The checks run the tests of {@code CoffeeMachineTest} as they are given here (changing them won't help), and more tests of their own.
 * Hints
 * 1. Start with {@code newMachineIsFull}: the machine needs to remember how much water its tank has, in an instance variable set in the constructor. {@code refill} needs the capacity too, so keep both: {@code capacity} and {@code left}.
 * 2. In {@code brew}: {@code if (ml > this.left) { this.left = 0; } else { this.left = this.left - ml; }}. In {@code refill}: {@code this.left = this.capacity;}.
 */
public class CoffeeMachine {
    public CoffeeMachine(int capacity) {
    }

    public void brew(int ml) {
    }

    public void refill() {
    }

    public int left() {
        return 0;
    }
}
