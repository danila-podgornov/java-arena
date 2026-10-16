// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step04_the_command_program_with_a_class_ai.challenge02_ai;

public class Concert {
    private int seats;
    private int sold;

    public Concert(int seats) {
        this.seats = seats;
        this.sold = 0;
    }

    public boolean sell(int count) {
        if (this.sold + count > this.seats) {
            return false;
        }
        this.sold = this.sold + count;
        return true;
    }

    public boolean refund(int count) {
        if (count > this.sold) {
            return false;
        }
        this.sold = this.sold - count;
        return true;
    }

    public int getSold() {
        return this.sold;
    }

    public int ticketsLeft() {
        return this.seats - this.sold;
    }
}
