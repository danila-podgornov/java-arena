// AI-Generated
package module40_class_diagrams_ai.step07_interfaces_and_a_whole_program_ai.challenge01_ai;

public class Main {
    /**
     * The ward's cleaning staff clean anything that's {@code Cleanable}. {@code Cleanable.java} is ready. Write the class {@code Wheelchair} in {@code Wheelchair.java}, as the diagram shows:
     * <pre>{@code
     * interface Cleanable
     * + clean(): void
     * + isClean(): boolean
     *
     * class Wheelchair implements Cleanable
     * - number: int
     * - uses: int
     * + Wheelchair(number: int)
     * + use(): void
     * + clean(): void
     * + isClean(): boolean
     * + toString(): String
     * }</pre>
     * <ul>
     * <li>A new wheelchair is clean: it has had no uses since it was last cleaned.
     * <li>{@code use} counts one use, and {@code clean} sets the count back to 0.
     * <li>{@code isClean} says whether the wheelchair has had no uses since it was last cleaned.
     * <li>{@code toString} returns {@code Wheelchair 7: 2 uses since cleaning}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Wheelchair chair = new Wheelchair(7);
     * chair.use();
     * chair.use();
     * System.out.println(chair + " " + chair.isClean());
     * Cleanable job = chair;
     * job.clean();
     * System.out.println(chair + " " + chair.isClean());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Wheelchair 7: 2 uses since cleaning false
     * Wheelchair 7: 0 uses since cleaning true
     * }</pre>
     * Hints
     * 1. The dashed triangle means {@code public class Wheelchair implements Cleanable}. The two fields are ints, and a new wheelchair starts with 0 uses.
     * 2. {@code clean} and {@code isClean} are Cleanable's methods, so they're {@code public}, with {@code @Override} above them. {@code isClean} returns {@code this.uses == 0}.
     */
    public static void main(String[] args) {
        Wheelchair chair = new Wheelchair(7);
        chair.use();
        chair.use();
        System.out.println(chair + " " + chair.isClean());
        Cleanable job = chair;
        job.clean();
        System.out.println(chair + " " + chair.isClean());
    }
}
