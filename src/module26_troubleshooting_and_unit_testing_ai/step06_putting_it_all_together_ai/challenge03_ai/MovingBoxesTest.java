// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step06_putting_it_all_together_ai.challenge03_ai;

import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class MovingBoxesTest {
    private MovingBoxes boxes;

    @Before
    public void setUp() {
        this.boxes = new MovingBoxes();
    }

    @Test
    public void countsLoadedAndLeft() {
        this.boxes.read(new Scanner("x books\nlamp\nx dishes\n"));
        assertEquals(2, this.boxes.loadedCount());
        assertEquals(1, this.boxes.leftToLoad());
    }

    @Test
    public void emptyLinesAreSkipped() {
        this.boxes.read(new Scanner("plants\n\nx chairs\n"));
        assertEquals(1, this.boxes.loadedCount());
        assertEquals(1, this.boxes.leftToLoad());
    }

    @Test
    public void doneWhenEverythingIsLoaded() {
        this.boxes.read(new Scanner("x books\nx rug\n"));
        assertTrue(this.boxes.isDone());
    }

    @Test
    public void notDoneWithSomethingLeft() {
        this.boxes.read(new Scanner("x books\nmirror\n"));
        assertFalse(this.boxes.isDone());
    }
}
