// AI-Generated
package module33_grouping_data_with_hash_maps_ai.step04_fast_lookups_and_the_end_of_part_8_ai.challenge03_ai;

public class Main {
    /**
     * To end part 8: a photo library. {@code Photo.java} is ready: a photo has a file name, a place and a year, with the getters {@code getFile()}, {@code getPlace()} and {@code getYear()}, and its {@code toString} gives the file name and the year. File names are unique. In {@code PhotoLibrary.java}, write:
     * <ul>
     * <li>the constructor,
     * <li>{@code add(Photo photo)}, which adds a photo to the library,
     * <li>{@code find(String file)}, which returns the photo with that file name, or {@code null} if there's none,
     * <li>{@code photosAt(String place)}, which returns a list of the photos taken at that place, in the order they were added, or an empty list for a place with no photos,
     * <li>{@code places()}, which returns a new list of the places that have photos, in alphabetical order.
     * </ul>
     * <p>Keep the photos in two hash maps: one from a file name to its photo, so that {@code find} goes straight to it, and one from a place to the list of its photos. {@code add} puts each photo in both. {@code Main.java} is a test drive, and it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Bergen, Hanoi, Namib]
     * [dunes.jpg (2023), sunset.jpg (2024)]
     * fjord.jpg (2022)
     * null
     * 0
     * }</pre>
     * Hints
     * 1. Two instance variables: {@code private HashMap<String, Photo> byFile;} and {@code private HashMap<String, ArrayList<Photo>> byPlace;}, both created in the constructor. {@code find} is then one line, {@code return this.byFile.get(file);}.
     * 2. {@code add} puts the photo in {@code byFile} under {@code photo.getFile()}, and on its place's list in {@code byPlace}, creating the list for the place's first photo. {@code photosAt} and {@code places} work like {@code dishesAt} and {@code tables} in step 3.
     */
    public static void main(String[] args) {
        PhotoLibrary library = new PhotoLibrary();
        library.add(new Photo("dunes.jpg", "Namib", 2023));
        library.add(new Photo("wharf.jpg", "Bergen", 2021));
        library.add(new Photo("sunset.jpg", "Namib", 2024));
        library.add(new Photo("fjord.jpg", "Bergen", 2022));
        library.add(new Photo("market.jpg", "Hanoi", 2024));
        System.out.println(library.places());
        System.out.println(library.photosAt("Namib"));
        System.out.println(library.find("fjord.jpg"));
        System.out.println(library.find("glacier.jpg"));
        System.out.println(library.photosAt("Lima").size());
    }
}
