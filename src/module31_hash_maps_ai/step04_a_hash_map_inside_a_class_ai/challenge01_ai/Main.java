// AI-Generated
package module31_hash_maps_ai.step04_a_hash_map_inside_a_class_ai.challenge01_ai;

public class Main {
    /**
     * An airport's baggage storage keeps travelers' bags on numbered shelves. Each bag gets a tag such as {@code B-417}, and the staff type the tags in any form: {@code  b-417} must find the same bag. Write the class {@code BagStorage}, which keeps the shelf of each bag in a {@code HashMap<String, Integer>}, with the tags as keys. Tidy every tag with {@code trim()} and {@code toUpperCase()} before it's used as a key. A private method {@code tidy} keeps that in one place.
     * <ul>
     * <li>The constructor creates the map.
     * <li>{@code leave(String tag, int shelf)} puts the bag on the shelf. When a bag with that tag is already stored, the staff have moved it: the method gives back the shelf it was on before. For a new bag, it gives back -1.
     * <li>{@code collect(String tag)} is for a traveler who comes back for a bag. It gives back the shelf to fetch the bag from, and after that the bag isn't stored anymore. For a tag that isn't stored, it gives back -1.
     * <li>{@code bagsStored()} returns how many bags are stored.
     * </ul>
     * <p>{@code Main.java} is a test drive, and prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * -1
     * -1
     * 3
     * 2
     * 1 -1 1
     * }</pre>
     * Hints
     * 1. The constructor needs {@code this.shelves = new HashMap<>();}, or the map stays {@code null}. Then write {@code private String tidy(String tag) { return tag.trim().toUpperCase(); }}, and call it first in every method that gets a tag.
     * 2. {@code leave} and {@code collect} both start by getting the shelf the map has for the tag, {@code getOrDefault(key, -1)}, which is -1 for a tag that isn't stored. Then {@code leave} puts the new shelf, which replaces an old one, and {@code collect} takes the tag out with {@code remove}. Both give back the shelf they got first.
     */
    public static void main(String[] args) {
        BagStorage storage = new BagStorage();
        System.out.println(storage.leave("B-417", 3));
        System.out.println(storage.leave(" c-802", 5));
        System.out.println(storage.leave("b-417 ", 1));
        System.out.println(storage.bagsStored());
        System.out.println(storage.collect("B-417") + " " + storage.collect("b-417") + " " + storage.bagsStored());
    }
}
