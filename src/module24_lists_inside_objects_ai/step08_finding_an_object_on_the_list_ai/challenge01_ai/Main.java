// AI-Generated
package module24_lists_inside_objects_ai.step08_finding_an_object_on_the_list_ai.challenge01_ai;

public class Main {
    /**
     * A hotel keeps a list of its rooms. {@code Room.java} is ready: a room has a number and a number of beds, with the getter {@code getBeds()}. In {@code Hotel.java}, write the method {@code findRoom(int people)}: it returns the first room on the list with at least that many beds, or {@code null} when there's no such room. The check runs:
     * <pre>{@code
     * Hotel hotel = new Hotel();
     * hotel.add(new Room(101, 1));
     * hotel.add(new Room(102, 2));
     * hotel.add(new Room(201, 4));
     * System.out.println(hotel.findRoom(2));
     * System.out.println(hotel.findRoom(3));
     * System.out.println(hotel.findRoom(5));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Room 102, 2 beds
     * Room 201, 4 beds
     * null
     * }</pre>
     * Hints
     * 1. The method's return type is the class of what it finds. Go through the rooms and return the first one that's big enough. If the loop ends without returning, no room was.
     * 2. <code>public Room findRoom(int people) {</code>, then in {@code for (Room room : this.rooms)}, {@code if (room.getBeds() >= people) { return room; }}. After the loop: {@code return null;}.
     */
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.add(new Room(101, 1));
        hotel.add(new Room(102, 2));
        hotel.add(new Room(201, 4));
        System.out.println(hotel.findRoom(2));
        System.out.println(hotel.findRoom(3));
        System.out.println(hotel.findRoom(5));
    }
}
