// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step04_the_command_program_with_a_class_ai.challenge03_ai;

public class BikeDock {
    private int slots;
    private int bikes;

    public BikeDock(int slots, int bikes) {
        this.slots = slots;
        this.bikes = bikes;
    }

    public boolean rent(int count) {
        if (count > this.bikes) {
            return false;
        }
        this.bikes = this.bikes - count;
        return true;
    }

    public boolean bringBack(int count) {
        if (count > this.freeSlots()) {
            return false;
        }
        this.bikes = this.bikes + count;
        return true;
    }

    public int getBikes() {
        return this.bikes;
    }

    public int freeSlots() {
        return this.slots - this.bikes;
    }
}
