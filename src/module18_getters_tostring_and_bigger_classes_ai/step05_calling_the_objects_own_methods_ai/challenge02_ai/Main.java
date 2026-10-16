// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step05_calling_the_objects_own_methods_ai.challenge02_ai;

public class Main {
    /**
     * An {@code EggCarton} holds at most 12 eggs. Add two methods. {@code add()} puts one egg in, unless the carton is full: use {@code isFull()} to check. {@code addMany(int count)} adds {@code count} eggs by calling {@code add()} that many times, so it can't overfill the carton either. The check adds 1 egg and then 8, prints the number of eggs, adds 8 more and prints it again: see the expected output below.
     * Expected output
     * <pre>{@code
     * 9
     * 12
     * }</pre>
     * Hints
     * 1. {@code add()} has an {@code if}: only when the carton is not full, {@code this.eggs++}. "Not full" is {@code !this.isFull()}.
     * 2. {@code addMany} is a loop that runs {@code count} times and calls {@code this.add();} each time.
     */
    public static void main(String[] args) {
        EggCarton carton = new EggCarton();
        carton.addMany(14);
        System.out.println(carton.getEggs() + " eggs");
    }
}
