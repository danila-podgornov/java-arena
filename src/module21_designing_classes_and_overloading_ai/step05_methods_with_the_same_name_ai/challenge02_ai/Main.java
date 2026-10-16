// AI-Generated
package module21_designing_classes_and_overloading_ai.step05_methods_with_the_same_name_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? The kitchen scale has three {@code add} methods, and two of them call another one.
     * Hints
     * 1. {@code "egg"} is a String, so it runs {@code add(String item)}, which calls {@code add(int grams)} with 60. That's the method that prints {@code Added}.
     * 2. {@code "250"} is in quotes, so it's a String too, and it isn't an egg or an apple. {@code add(40, 2)} calls {@code add(int grams)} twice, and each call prints a line. The total counts only what went through {@code add(int grams)}.
     */
    public static void main(String[] args) {
        KitchenScale scale = new KitchenScale();
        scale.add(250);
        scale.add("egg");
        scale.add("250");
        scale.add(40, 2);
        System.out.println(scale.getGrams() + " g in total");
    }
}
