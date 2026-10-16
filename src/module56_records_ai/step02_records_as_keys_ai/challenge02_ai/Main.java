// AI-Generated
package module56_records_ai.step02_records_as_keys_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    /**
     * A robot vacuum notes the cell of the floor grid it's in once a minute. {@code Cell} is a record with the column {@code x} and the row {@code y}. In {@code Main.java}, write the method {@code countVisits(ArrayList<Cell> path)}, which returns a {@code HashMap<Cell, Integer>} from each cell on the path to how many times it's there. The check runs:
     * <pre>{@code
     * ArrayList<Cell> path = new ArrayList<>();
     * path.add(new Cell(0, 0));
     * path.add(new Cell(0, 1));
     * path.add(new Cell(0, 0));
     * path.add(new Cell(2, 1));
     * path.add(new Cell(0, 0));
     * HashMap<Cell, Integer> visits = countVisits(path);
     * System.out.println(visits.size() + " different cells");
     * System.out.println(visits.get(new Cell(0, 0)));
     * System.out.println(visits.get(new Cell(2, 1)));
     * System.out.println(visits.getOrDefault(new Cell(1, 0), 0));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3 different cells
     * 3
     * 1
     * 0
     * }</pre>
     * Hints
     * 1. Go through the path with a for-each loop. For each cell, put it in the map with one more than it had: {@code visits.getOrDefault(cell, 0) + 1}.
     * 2. Cell is a record, so two {@code new Cell(0, 0)} objects are the same key: the map adds up their visits without any {@code equals} or {@code hashCode} of your own.
     */
    public static void main(String[] args) {
        ArrayList<Cell> path = new ArrayList<>();
        path.add(new Cell(0, 0));
        path.add(new Cell(0, 1));
        path.add(new Cell(0, 0));
        path.add(new Cell(2, 1));
        path.add(new Cell(0, 0));
        HashMap<Cell, Integer> visits = countVisits(path);
        System.out.println(visits.size() + " different cells");
        System.out.println(visits.get(new Cell(0, 0)));
        System.out.println(visits.get(new Cell(2, 1)));
        System.out.println(visits.getOrDefault(new Cell(1, 0), 0));
    }

    public static HashMap<Cell, Integer> countVisits(ArrayList<Cell> path) {
        HashMap<Cell, Integer> visits = new HashMap<>();
        return visits;
    }
}
