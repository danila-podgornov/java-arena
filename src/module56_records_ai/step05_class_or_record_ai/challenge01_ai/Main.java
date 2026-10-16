// AI-Generated
package module56_records_ai.step05_class_or_record_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A quilting club's app has the class {@code Quilt} below, written the long way, with getters and its own {@code equals}, {@code hashCode} and {@code toString}. A finished quilt never changes, so it can be a record. Turn {@code Quilt} into a record with the components {@code name} and {@code squares}, with no {@code equals} or {@code hashCode} of your own, and change {@code Main} to use the accessors. The program must print exactly what it prints now: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * Quilt[name=Starburst, squares=12]
     * 21 squares in all
     * LOG CABIN
     * }</pre>
     * Hints
     * 1. A record puts its components in parentheses after its name, {@code record Quilt(...)}. The fields, the constructor, the getters, {@code equals}, {@code hashCode} and {@code toString} all go away, and so does the {@code import} of Objects.
     * 2. The whole class becomes {@code public record Quilt(String name, int squares) { }}. The record's {@code toString} already prints {@code Quilt[name=Starburst, squares=12]}, and its {@code equals} makes {@code contains} work. In Main, {@code getSquares()} becomes {@code squares()} and {@code getName()} becomes {@code name()}.
     */
    public static void main(String[] args) {
        ArrayList<Quilt> quilts = new ArrayList<>();
        quilts.add(new Quilt("Starburst", 12));
        quilts.add(new Quilt("Log Cabin", 9));
        System.out.println(quilts.contains(new Quilt("Log Cabin", 9)));
        System.out.println(quilts.get(0));
        int total = 0;
        for (Quilt quilt : quilts) {
            total = total + quilt.getSquares();
        }
        System.out.println(total + " squares in all");
        System.out.println(quilts.get(1).getName().toUpperCase());
    }
}
