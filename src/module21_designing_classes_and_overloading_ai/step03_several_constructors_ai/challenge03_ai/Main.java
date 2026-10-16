// AI-Generated
package module21_designing_classes_and_overloading_ai.step03_several_constructors_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? {@code Label} has three constructors. Look at the type of each value given to {@code new}.
     * Hints
     * 1. {@code new Label(7)} gives an int, so it runs {@code Label(int number)}. {@code new Label()} gives nothing, so it runs the constructor without parameters.
     * 2. {@code "7"} is in quotes, so it's a String, even though it looks like a number. It runs {@code Label(String text)}.
     */
    public static void main(String[] args) {
        Label a = new Label("Spices");
        Label b = new Label(7);
        Label c = new Label();
        Label d = new Label("7");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
