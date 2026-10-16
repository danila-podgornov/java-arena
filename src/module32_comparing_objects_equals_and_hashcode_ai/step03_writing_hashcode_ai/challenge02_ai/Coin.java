// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step03_writing_hashcode_ai.challenge02_ai;

public class Coin {
    private String country;
    private int year;
    private int cents;

    public Coin(String country, int year, int cents) {
        this.country = country;
        this.year = year;
        this.cents = cents;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Coin)) {
            return false;
        }
        Coin other = (Coin) compared;
        return this.country.equals(other.country) && this.year == other.year && this.cents == other.cents;
    }

    // Write the hashCode method here.

    public String toString() {
        return this.country + " " + this.year + " " + this.cents + "c";
    }
}
