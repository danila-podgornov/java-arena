// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge01_ai.foodtruck.domain;

public class Dish {
    private String name;
    private int price;

    public Dish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.price + " dollars)";
    }
}
