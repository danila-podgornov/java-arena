// AI-Generated
package module21_designing_classes_and_overloading_ai.step04_one_constructor_calling_another_ai.challenge03_ai;

public class Lantern {
    private String material;
    private int candles;

    public Lantern() {
        this("paper");
        System.out.println("The usual lantern");
    }

    public Lantern(String material) {
        this(material, 1);
        System.out.println("Made of " + material);
    }

    public Lantern(String material, int candles) {
        this.material = material;
        this.candles = candles;
        System.out.println("Candles: " + candles);
    }
}
