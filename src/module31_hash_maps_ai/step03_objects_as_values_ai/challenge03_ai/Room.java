// AI-Generated
package module31_hash_maps_ai.step03_objects_as_values_ai.challenge03_ai;

public class Room {
    private int number;
    private String guest;

    public Room(int number) {
        this.number = number;
        this.guest = null;
    }

    public int getNumber() {
        return this.number;
    }

    public String getGuest() {
        return this.guest;
    }

    public boolean isFree() {
        return this.guest == null;
    }

    public void checkIn(String guest) {
        this.guest = guest;
    }

    public void checkOut() {
        this.guest = null;
    }

    public String toString() {
        if (this.isFree()) {
            return "Room " + this.number + ": free";
        }
        return "Room " + this.number + ": " + this.guest;
    }
}
