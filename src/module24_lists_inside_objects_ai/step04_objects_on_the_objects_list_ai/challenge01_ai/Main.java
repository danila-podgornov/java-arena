// AI-Generated
package module24_lists_inside_objects_ai.step04_objects_on_the_objects_list_ai.challenge01_ai;

public class Main {
    /**
     * A parking garage keeps a list of the cars parked in it. {@code Car.java} is ready: a car has a license plate and a color, with the getters {@code getPlate()} and {@code getColor()}. In {@code Garage.java}, add a private list of cars as an instance variable, and make it in the constructor. Then write two methods: {@code park(Car car)} adds the car to the list, and {@code printColor(String color)} prints every car of that color, one per line, in the order they were parked. The check runs:
     * <pre>{@code
     * Garage garage = new Garage();
     * garage.park(new Car("ABC-123", "red"));
     * garage.park(new Car("XYZ-789", "blue"));
     * garage.park(new Car("JKL-456", "red"));
     * garage.printColor("red");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * ABC-123 (red)
     * JKL-456 (red)
     * }</pre>
     * Hints
     * 1. The list holds Car objects: {@code private ArrayList<Car> cars;}, and the constructor makes it with {@code this.cars = new ArrayList<>();}. {@code park} adds the car it's given: {@code this.cars.add(car);}.
     * 2. {@code printColor} goes through the cars with {@code for (Car car : this.cars)}, and prints a car when {@code car.getColor().equals(color)}.
     */
    public static void main(String[] args) {
        Garage garage = new Garage();
        garage.park(new Car("ABC-123", "red"));
        garage.park(new Car("XYZ-789", "blue"));
        garage.park(new Car("JKL-456", "red"));
        garage.printColor("red");
    }
}
