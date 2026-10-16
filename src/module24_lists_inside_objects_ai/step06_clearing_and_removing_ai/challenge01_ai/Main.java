// AI-Generated
package module24_lists_inside_objects_ai.step06_clearing_and_removing_ai.challenge01_ai;

public class Main {
    /**
     * A fridge keeps a list of foods, and each food knows how many days it has left. {@code Food.java} is ready, with the getter {@code getDaysLeft()}. In {@code Fridge.java}, write the method {@code throwOutOld()}: it removes every food with less than 1 day left, and keeps the rest in their order. The check runs:
     * <pre>{@code
     * Fridge fridge = new Fridge();
     * fridge.put(new Food("cheese", 12));
     * fridge.put(new Food("milk", 0));
     * fridge.put(new Food("yogurt", -1));
     * fridge.put(new Food("jam", 90));
     * fridge.throwOutOld();
     * System.out.println(fridge);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code Fridge: [cheese (12 days), jam (90 days)]}
     * Hints
     * 1. A for-each loop can't remove from the list it goes through. Loop over the indexes backwards: {@code for (int i = this.foods.size() - 1; i >= 0; i--)}.
     * 2. In the loop, {@code this.foods.get(i).getDaysLeft()} is the food's days left. When it's less than 1, {@code this.foods.remove(i);} removes it by its index.
     */
    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.put(new Food("cheese", 12));
        fridge.put(new Food("milk", 0));
        fridge.put(new Food("yogurt", -1));
        fridge.put(new Food("jam", 90));
        fridge.throwOutOld();
        System.out.println(fridge);
    }
}
