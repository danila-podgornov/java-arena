// AI-Generated
package module21_designing_classes_and_overloading_ai.step02_designing_a_class_ai.challenge02_ai;

public class Train {
    private String name;
    private int cars;

    public Train(String name) {
        this.name = name;
        this.cars = 1;
    }

    public void addCar() {
        this.cars = this.cars + 1;
    }

    public void removeCar() {
        if (this.cars > 1) {
            this.cars = this.cars - 1;
        }
    }

    public int seats() {
        return this.cars * 60;
    }

    public String toString() {
        return this.name + ": " + this.cars + " cars, " + this.seats() + " seats";
    }
}
