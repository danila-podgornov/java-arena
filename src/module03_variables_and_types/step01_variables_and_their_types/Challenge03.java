package module03_variables_and_types.step01_variables_and_their_types;

public class Challenge03 {
    /**
     * Create four variables: a String {@code name} holding {@code Kai}, an int {@code age} holding {@code 17}, a double {@code height} holding {@code 1.82} and a boolean {@code student} holding {@code true}. Then print them with labels, using the variables (not the values typed into the text): see the expected output below.
     * Expected output
     * <pre>{@code
     * Name: Kai
     * Age: 17
     * Height: 1.82
     * Student: true
     * }</pre>
     */
    public static void main(String[] args) {
        // Four variables, then four lines of output.
        String name = "Kai";
        int age = 17;
        double height = 1.82;
        boolean student = true;
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Student: " + student);
    }
}
