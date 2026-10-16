// AI-Generated
package module56_records_ai.step02_records_as_keys_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    /**
     * Volunteers counting birds note each sighting as the bird and the numbered square of the nature reserve where it was seen. When two volunteers note the same bird in the same square, that's one sighting. In {@code Main.java}, write the method {@code withoutRepeats(ArrayList<Sighting> sightings)}, which returns a new list with each different sighting once, in the order it first came. Use a {@code HashSet<Sighting>} to remember which sightings you've already taken. The check runs:
     * <pre>{@code
     * ArrayList<Sighting> notes = new ArrayList<>();
     * notes.add(new Sighting("heron", 4));
     * notes.add(new Sighting("crane", 4));
     * notes.add(new Sighting("heron", 4));
     * notes.add(new Sighting("heron", 7));
     * notes.add(new Sighting("crane", 4));
     * ArrayList<Sighting> unique = withoutRepeats(notes);
     * System.out.println(unique);
     * System.out.println(notes.size() + " notes, " + unique.size() + " sightings");
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [Sighting[bird=heron, square=4], Sighting[bird=crane, square=4], Sighting[bird=heron, square=7]]
     * 5 notes, 3 sightings
     * }</pre>
     * Hints
     * 1. Make an empty {@code HashSet<Sighting>} and an empty {@code ArrayList<Sighting>}. Go through the sightings in order; one that isn't in the set yet goes into both.
     * 2. {@code seen.add(sighting)} returns {@code true} only when the sighting wasn't in the set yet, so it can be the if's condition. The list keeps the order; the set only answers "seen before?".
     */
    public static void main(String[] args) {
        ArrayList<Sighting> notes = new ArrayList<>();
        notes.add(new Sighting("heron", 4));
        notes.add(new Sighting("crane", 4));
        notes.add(new Sighting("heron", 4));
        notes.add(new Sighting("heron", 7));
        notes.add(new Sighting("crane", 4));
        ArrayList<Sighting> unique = withoutRepeats(notes);
        System.out.println(unique);
        System.out.println(notes.size() + " notes, " + unique.size() + " sightings");
    }

    public static ArrayList<Sighting> withoutRepeats(ArrayList<Sighting> sightings) {
        return sightings;
    }
}
