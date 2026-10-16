// AI-Generated
package module21_designing_classes_and_overloading_ai.step02_designing_a_class_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? It uses the {@code Train} class from the lesson.
     * Hints
     * 1. Every train starts with one car. The morning train gets two cars added and one taken off.
     * 2. The night train can't lose its only car, so its {@code removeCar()} changes nothing. Then it gets two cars added, and {@code seats()} multiplies its cars by 60.
     */
    public static void main(String[] args) {
        Train morning = new Train("Morning Express");
        Train night = new Train("Night Owl");
        morning.addCar();
        night.removeCar();
        night.addCar();
        night.addCar();
        morning.addCar();
        morning.removeCar();
        System.out.println(morning);
        System.out.println(night.seats());
    }
}
