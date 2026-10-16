// AI-Generated
package module24_lists_inside_objects_ai.step02_a_list_as_an_instance_variable_ai.challenge01_ai;

public class Main {
    /**
     * A photo album has a title and a list of photo names. In {@code PhotoAlbum.java}, add a private instance variable {@code photos}, a list of Strings, and make a new, empty list for it in the constructor. Then write two methods: {@code add(String photo)} adds the photo to the list, and {@code count()} returns how many photos the album holds. The check runs:
     * <pre>{@code
     * PhotoAlbum trip = new PhotoAlbum("Summer trip");
     * trip.add("beach.jpg");
     * trip.add("tent.jpg");
     * PhotoAlbum winter = new PhotoAlbum("Winter");
     * System.out.println(trip.getTitle() + ": " + trip.count());
     * System.out.println(winter.getTitle() + ": " + winter.count());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Summer trip: 2
     * Winter: 0
     * }</pre>
     * Hints
     * 1. Declare the list next to {@code title}: {@code private ArrayList<String> photos;}. In the constructor, give it a new list: {@code this.photos = new ArrayList<>();}.
     * 2. {@code add} passes the photo on to the list, {@code this.photos.add(photo);}, and {@code count} returns {@code this.photos.size();}.
     */
    public static void main(String[] args) {
        PhotoAlbum trip = new PhotoAlbum("Summer trip");
        trip.add("beach.jpg");
        trip.add("tent.jpg");
        PhotoAlbum winter = new PhotoAlbum("Winter");
        System.out.println(trip.getTitle() + ": " + trip.count());
        System.out.println(winter.getTitle() + ": " + winter.count());
    }
}
