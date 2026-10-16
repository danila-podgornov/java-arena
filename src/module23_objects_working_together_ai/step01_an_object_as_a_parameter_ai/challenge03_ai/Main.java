// AI-Generated
package module23_objects_working_together_ai.step01_an_object_as_a_parameter_ai.challenge03_ai;

public class Main {
    /**
     * A kettle pours hot water into cups. {@code Cup.java} is ready: {@code space()} returns how many milliliters still fit in the cup, and {@code fill(int ml)} adds water to it. In {@code Kettle.java}, write the method {@code pour(Cup cup)}. It pours until the cup is full or the kettle is empty, whichever comes first, and the kettle then has that much less water. The check runs:
     * <pre>{@code
     * Kettle kettle = new Kettle(500);
     * Cup mug = new Cup(300);
     * Cup glass = new Cup(250);
     * kettle.pour(mug);
     * kettle.pour(glass);
     * System.out.println(mug);
     * System.out.println(glass);
     * System.out.println(kettle);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 300/300 ml
     * 200/250 ml
     * Kettle: 0 ml
     * }</pre>
     * Hints
     * 1. The amount to pour is the smaller of two numbers: the kettle's own {@code this.water} and the cup's {@code cup.space()}. {@code Math.min} gives the smaller one.
     * 2. Then give the cup that amount with {@code cup.fill(amount);}, and take it from the kettle: {@code this.water = this.water - amount;}.
     */
    public static void main(String[] args) {
        Kettle kettle = new Kettle(500);
        Cup mug = new Cup(300);
        Cup glass = new Cup(250);
        kettle.pour(mug);
        kettle.pour(glass);
        System.out.println(mug);
        System.out.println(glass);
        System.out.println(kettle);
    }
}
