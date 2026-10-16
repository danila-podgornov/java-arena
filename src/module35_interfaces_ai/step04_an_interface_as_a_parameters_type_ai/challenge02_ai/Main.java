// AI-Generated
package module35_interfaces_ai.step04_an_interface_as_a_parameters_type_ai.challenge02_ai;

public class Main {
    /**
     * The method {@code cheaper} takes two priced things, and returns the label of the cheaper one. What does this program print?
     * Hints
     * 1. A repair costs 2 dollars a minute: 12 minutes is 24 dollars, 20 minutes is 40, and 9 minutes is 18. Each object's own {@code price} runs.
     * 2. With {@code <=}, a tie goes to {@code first}. Repair(20) and the wall clock both cost 40, and Repair(9) and the chain both cost 18.
     */
    public static void main(String[] args) {
        System.out.println(cheaper(new Product("Stopwatch", 30), new Repair(12)));
        System.out.println(cheaper(new Repair(20), new Product("Wall clock", 40)));
        Priced chain = new Product("Chain", 18);
        System.out.println(cheaper(chain, chain) + " " + cheaper(new Repair(9), chain));
    }

    public static String cheaper(Priced first, Priced second) {
        if (first.price() <= second.price()) {
            return first.label();
        }
        return second.label();
    }
}
