// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step08_why_lookups_stay_fast_ai.challenge01_ai;

public class Main {
    /**
     * This time count the comparisons yourself. {@code SimpleList} and {@code SimpleMap} are the counting versions from this step, except that this map has no {@code grow}: it keeps its 8 buckets. An Integer's hash code is its own value. The counts add up: each {@code getComparisons()} gives every comparison made so far. What does this program print?
     * Hints
     * 1. The list compares from the start: ash is the third value, so finding it takes 3 comparisons. Pine isn't there, so {@code contains} compares with all 5 values. The count goes on from 3.
     * 2. Only {@code get} counts in the map. 3, 11 and 19 all go to bucket 3, in that order, so {@code get(19)} compares 3 times. 27 goes to bucket 3 too, and isn't there. 5 goes to bucket 5, which is empty: no comparisons at all.
     */
    public static void main(String[] args) {
        SimpleList<String> trees = new SimpleList<>();
        String[] names = {"oak", "elm", "ash", "fir", "yew"};
        for (String name : names) {
            trees.add(name);
        }
        trees.contains("ash");
        System.out.println(trees.getComparisons());
        trees.contains("pine");
        System.out.println(trees.getComparisons());

        SimpleMap<Integer, String> plots = new SimpleMap<>();
        plots.put(3, "beans");
        plots.put(11, "kale");
        plots.put(19, "leeks");
        plots.put(4, "chard");
        plots.get(19);
        System.out.println(plots.getComparisons());
        plots.get(27);
        plots.get(5);
        System.out.println(plots.getComparisons());
    }
}
