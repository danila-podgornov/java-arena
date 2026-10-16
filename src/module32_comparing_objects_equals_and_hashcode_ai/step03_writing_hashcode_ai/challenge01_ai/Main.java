// AI-Generated
package module32_comparing_objects_equals_and_hashcode_ai.step03_writing_hashcode_ai.challenge01_ai;

import java.util.HashMap;

public class Main {
    /**
     * The board game's squares get hash codes of their own. In {@code Square.java}, write {@code hashCode}: 31 times the hash code of the column, plus the row. The check lets players claim squares, and looks them up with new squares:
     * <pre>{@code
     * HashMap<Square, String> owners = new HashMap<>();
     * owners.put(new Square("A", 1), "Ada");
     * owners.put(new Square("E", 1), "Ben");
     * owners.put(new Square("A", 1), "Cy");
     * System.out.println(owners.get(new Square("A", 1)));
     * System.out.println(owners.containsKey(new Square("E", 2)));
     * System.out.println(owners.size());
     * System.out.println(new Square("E", 1).hashCode());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Cy
     * false
     * 2
     * 2140
     * }</pre>
     * Hints
     * 1. The header is <code>public int hashCode() {</code>. The column is a String, so its hash code is {@code this.column.hashCode()}.
     * 2. {@code return 31 * this.column.hashCode() + this.row;}: the two values that {@code equals} compares, and nothing else.
     */
    public static void main(String[] args) {
        HashMap<Square, String> owners = new HashMap<>();
        owners.put(new Square("A", 1), "Ada");
        owners.put(new Square("E", 1), "Ben");
        owners.put(new Square("A", 1), "Cy");
        System.out.println(owners.get(new Square("A", 1)));
        System.out.println(owners.containsKey(new Square("E", 2)));
        System.out.println(owners.size());
        System.out.println(new Square("E", 1).hashCode());
    }
}
