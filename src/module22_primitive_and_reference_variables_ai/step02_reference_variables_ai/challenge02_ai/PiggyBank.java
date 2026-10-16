// AI-Generated
package module22_primitive_and_reference_variables_ai.step02_reference_variables_ai.challenge02_ai;

public class PiggyBank {
    private String owner;
    private int euros;

    public PiggyBank(String owner) {
        this.owner = owner;
        this.euros = 0;
    }

    public void deposit(int euros) {
        this.euros = this.euros + euros;
    }

    public String toString() {
        return this.owner + ": " + this.euros + " euros";
    }
}
