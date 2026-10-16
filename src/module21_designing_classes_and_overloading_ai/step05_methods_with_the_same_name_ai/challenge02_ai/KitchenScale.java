// AI-Generated
package module21_designing_classes_and_overloading_ai.step05_methods_with_the_same_name_ai.challenge02_ai;

public class KitchenScale {
    private int grams;

    public KitchenScale() {
        this.grams = 0;
    }

    public void add(int grams) {
        this.grams = this.grams + grams;
        System.out.println("Added " + grams + " g");
    }

    public void add(String item) {
        if (item.equals("egg")) {
            this.add(60);
        } else if (item.equals("apple")) {
            this.add(150);
        } else {
            System.out.println("Unknown: " + item);
        }
    }

    public void add(int grams, int times) {
        for (int i = 0; i < times; i++) {
            this.add(grams);
        }
    }

    public int getGrams() {
        return this.grams;
    }
}
