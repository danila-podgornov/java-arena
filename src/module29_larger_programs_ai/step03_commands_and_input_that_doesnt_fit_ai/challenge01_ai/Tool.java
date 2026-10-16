// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge01_ai;

public class Tool {
    private String name;
    private String borrower;

    public Tool(String name) {
        this.name = name;
        this.borrower = null;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return this.borrower == null;
    }

    public void lendTo(String person) {
        this.borrower = person;
    }

    public void giveBack() {
        this.borrower = null;
    }

    public String toString() {
        if (this.borrower == null) {
            return this.name + ": on the shelf";
        }
        return this.name + ": lent to " + this.borrower;
    }
}
