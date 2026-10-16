// AI-Generated
package module23_objects_working_together_ai.step08_putting_it_all_together_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * What does this program print? It uses the {@code Position} class from the lesson, and a list of the places visited so far.
     * Hints
     * 1. Each {@code moved} call makes a new Position, and {@code here} is set to refer to it. After moving right and back left, {@code here} is at (0, 0) again, but it's a third object, not the first one.
     * 2. {@code contains} and {@code indexOf} use {@code equals}, so they find equal positions. {@code ==} asks about the very same object.
     */
    public static void main(String[] args) {
        ArrayList<Position> visited = new ArrayList<>();
        Position here = new Position(0, 0);
        visited.add(here);
        here = here.moved(1, 0);
        visited.add(here);
        here = here.moved(-1, 0);
        System.out.println(here);
        System.out.println(visited.contains(here));
        System.out.println(here == visited.get(0));
        System.out.println(visited.indexOf(new Position(1, 0)));
    }
}
