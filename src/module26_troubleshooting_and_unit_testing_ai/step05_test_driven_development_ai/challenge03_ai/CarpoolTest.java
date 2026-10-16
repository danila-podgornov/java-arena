// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step05_test_driven_development_ai.challenge03_ai;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarpoolTest {
    @Test
    public void joiningAddsARider() {
        Carpool carpool = new Carpool(3);
        assertTrue(carpool.join("Mia"));
        assertEquals(1, carpool.riders());
    }

    @Test
    public void sameNameCannotJoinTwice() {
        Carpool carpool = new Carpool(3);
        carpool.join("Mia");
        assertFalse(carpool.join("Mia"));
        assertEquals(1, carpool.riders());
    }

    @Test
    public void fullCarTakesNobodyMore() {
        Carpool carpool = new Carpool(2);
        carpool.join("Ann");
        carpool.join("Ben");
        assertTrue(carpool.isFull());
        assertFalse(carpool.join("Cy"));
    }

    @Test
    public void leavingMakesRoom() {
        Carpool carpool = new Carpool(1);
        carpool.join("Ann");
        carpool.leave("Ann");
        assertFalse(carpool.isFull());
        assertTrue(carpool.join("Ben"));
    }
}
