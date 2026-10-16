// AI-Generated
package module17_classes_and_objects_ai.step06_several_objects_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? There are three candles, and two of them have the same scent.
     * Hints
     * 1. Follow each candle on its own. {@code a} burns 20 and then 10 minutes, {@code c} burns 20, and {@code b} burns 70.
     * 2. {@code a} and {@code c} have the same scent but are two separate objects. {@code b} would go below 0, so {@code burn} stops it at 0.
     */
    public static void main(String[] args) {
        Candle a = new Candle("vanilla", 60);
        Candle b = new Candle("pine", 60);
        Candle c = new Candle("vanilla", 30);
        a.burn(20);
        c.burn(20);
        b.burn(70);
        a.burn(10);
        a.printInfo();
        b.printInfo();
        c.printInfo();
    }
}
