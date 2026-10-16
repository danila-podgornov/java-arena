// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step03_switch_on_sealed_types_ai.challenge02_ai;

public class Main {
    /**
     * The floor plan app gets a third shape, {@code Triangle(double base, double height)}, for attic rooms. It's already in {@code Triangle.java} and in Shape's permits list, but now {@code Main.java} doesn't compile: press Run, and javac names both switch expressions. Add a case for triangles to each: a triangle's area is base times height divided by 2, and its label is {@code triangle}, the base, {@code x}, and the height, like the other labels. Don't add a {@code default}. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * rectangle 5.0 x 4.5: 22.5
     * circle radius 1.5: 7.0685834705770345
     * triangle 4.0 x 2.5: 5.0
     * }</pre>
     * Hints
     * 1. javac's two errors point at the two {@code switch} lines: each needs a {@code case Triangle triangle -> ...}.
     * 2. The area is {@code triangle.base() * triangle.height() / 2}, and the label {@code "triangle " + triangle.base() + " x " + triangle.height()}.
     */
    public static void main(String[] args) {
        Shape[] rooms = {new Rectangle(5.0, 4.5), new Circle(1.5), new Triangle(4.0, 2.5)};
        for (Shape room : rooms) {
            System.out.println(label(room) + ": " + area(room));
        }
    }

    public static double area(Shape shape) {
        return switch (shape) {
            case Rectangle rectangle -> rectangle.width() * rectangle.depth();
            case Circle circle -> Math.PI * circle.radius() * circle.radius();
        };
    }

    public static String label(Shape shape) {
        return switch (shape) {
            case Rectangle rectangle -> "rectangle " + rectangle.width() + " x " + rectangle.depth();
            case Circle circle -> "circle radius " + circle.radius();
        };
    }
}
