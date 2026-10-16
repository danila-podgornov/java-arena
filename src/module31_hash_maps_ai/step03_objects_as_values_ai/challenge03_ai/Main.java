// AI-Generated
package module31_hash_maps_ai.step03_objects_as_values_ai.challenge03_ai;

import java.util.HashMap;

public class Main {
    /**
     * A small hotel keeps its rooms in a {@code HashMap<Integer, Room>}, with the room numbers as keys. {@code Room.java} is ready: a room is free until a guest checks in, and it has the methods {@code isFree()}, {@code checkIn(String guest)} and {@code getGuest()}. In {@code Main.java}, write the method {@code checkInGuest(HashMap<Integer, Room> rooms, int number, String guest)}. It returns:
     * <ul>
     * <li>{@code No room } and the number, when the hotel has no room with that number,
     * <li>{@code Room }, the number and {@code  is taken}, when someone is already in the room,
     * <li>otherwise, it checks the guest in to the room and returns {@code Welcome, }, the guest, {@code ! Room } and the number.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * HashMap<Integer, Room> rooms = new HashMap<>();
     * rooms.put(101, new Room(101));
     * rooms.put(102, new Room(102));
     * System.out.println(checkInGuest(rooms, 102, "Achebe"));
     * System.out.println(checkInGuest(rooms, 102, "Moreau"));
     * System.out.println(checkInGuest(rooms, 105, "Moreau"));
     * System.out.println(rooms.get(102));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Welcome, Achebe! Room 102
     * Room 102 is taken
     * No room 105
     * Room 102: Achebe
     * }</pre>
     * Hints
     * 1. Keep the room in a variable, {@code Room room = rooms.get(number);}. When it's {@code null}, the hotel has no such room: return the message before calling anything on it.
     * 2. Then check {@code room.isFree()}. When it is free, {@code room.checkIn(guest);} changes the Room object that's in the map, so there's nothing to put back.
     */
    public static void main(String[] args) {
        HashMap<Integer, Room> rooms = new HashMap<>();
        rooms.put(101, new Room(101));
        rooms.put(102, new Room(102));
        System.out.println(checkInGuest(rooms, 102, "Achebe"));
        System.out.println(checkInGuest(rooms, 102, "Moreau"));
        System.out.println(checkInGuest(rooms, 105, "Moreau"));
        System.out.println(rooms.get(102));
    }

    // Write the method checkInGuest here.
}
