// AI-Generated
package module58_pattern_matching_and_sealed_types_ai.step03_switch_on_sealed_types_ai.challenge01_ai;

public class Main {
    /**
     * Back to the floor plan. This time the shapes are records with no methods of their own, and {@code Main.java} works out the areas. Write {@code area(Shape shape)} with a switch expression on {@code shape}: a rectangle's area is its width times its depth, and a circle's is {@code Math.PI} times the radius times the radius. Don't use {@code default} or {@code instanceof}. The program prints the area of each room and then the total: see the expected output below.
     * Expected output
     * <pre>{@code
     * Living room: 22.5
     * Bedroom: 12.0
     * Tower: 7.0685834705770345
     * Total: 41.56858347057703
     * }</pre>
     * Hints
     * 1. {@code return switch (shape) { ... };} with one case for each permitted type: {@code case Rectangle rectangle -> ...} and {@code case Circle circle -> ...}.
     * 2. In a case, read the values with the record's accessors: {@code rectangle.width() * rectangle.depth()}, {@code Math.PI * circle.radius() * circle.radius()}.
     */
    public static void main(String[] args) {
        Shape living = new Rectangle(5.0, 4.5);
        Shape bedroom = new Rectangle(4.0, 3.0);
        Shape tower = new Circle(1.5);
        System.out.println("Living room: " + area(living));
        System.out.println("Bedroom: " + area(bedroom));
        System.out.println("Tower: " + area(tower));
        System.out.println("Total: " + (area(living) + area(bedroom) + area(tower)));
    }

    public static double area(Shape shape) {
        return 0.0;
    }
}
