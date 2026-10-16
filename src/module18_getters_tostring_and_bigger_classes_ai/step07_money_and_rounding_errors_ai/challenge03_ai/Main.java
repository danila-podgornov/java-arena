// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step07_money_and_rounding_errors_ai.challenge03_ai;

public class Main {
    /**
     * A {@code VendingMachine} keeps the money put in as credit, in cents. Write two methods. {@code buy(int price)} takes the price off the credit and returns {@code true} when the credit covers the price; otherwise it returns {@code false}, and the credit stays as it was. {@code change()} returns the credit that's left and sets the credit to 0, as when the machine gives the coins back. The check puts in 200 cents, tries to buy two things that cost 150 cents, and asks for change twice: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * 50
     * 0
     * }</pre>
     * Hints
     * 1. {@code buy} returns a boolean: {@code if (this.credit >= price) { ... return true; }}, and {@code return false;} after it.
     * 2. {@code change()} has to remember the credit before setting it to 0: {@code int left = this.credit;}, then {@code this.credit = 0;}, then {@code return left;}
     */
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.insert(200);
        if (machine.buy(150)) {
            System.out.println("Enjoy your snack!");
        }
        System.out.println("Your change: " + machine.change() + " cents");
    }
}
