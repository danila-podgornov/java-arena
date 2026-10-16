// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step05_test_driven_development_ai.challenge01_ai;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeMachineTest {
    @Test
    public void newMachineIsFull() {
        CoffeeMachine machine = new CoffeeMachine(750);
        assertEquals(750, machine.left());
    }

    @Test
    public void brewingUsesWater() {
        CoffeeMachine machine = new CoffeeMachine(750);
        machine.brew(200);
        assertEquals(550, machine.left());
    }

    @Test
    public void cannotUseMoreThanIsLeft() {
        CoffeeMachine machine = new CoffeeMachine(500);
        machine.brew(300);
        machine.brew(300);
        assertEquals(0, machine.left());
    }

    @Test
    public void refillFillsItUp() {
        CoffeeMachine machine = new CoffeeMachine(500);
        machine.brew(450);
        machine.refill();
        assertEquals(500, machine.left());
    }
}
