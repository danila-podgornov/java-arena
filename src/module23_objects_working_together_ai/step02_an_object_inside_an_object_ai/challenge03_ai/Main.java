// AI-Generated
package module23_objects_working_together_ai.step02_an_object_inside_an_object_ai.challenge03_ai;

public class Main {
    /**
     * A train ticket keeps its route in a {@code Route} object, and {@code Route.java} is ready. In {@code Ticket.java}, write:
     * <ul>
     * <li>the constructor {@code Ticket(String passenger, String from, String to)}, which stores the passenger and makes the route itself, from {@code from} and {@code to};
     * <li>the method {@code goesTo(String city)}, which returns {@code true} when the ticket's route ends in that city. Ask the route where it ends with {@code getTo()}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Ticket ticket = new Ticket("Lea", "Harbor Town", "Hill Park");
     * System.out.println(ticket);
     * System.out.println(ticket.goesTo("Hill Park"));
     * System.out.println(ticket.goesTo("Harbor Town"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Lea: Harbor Town to Hill Park
     * true
     * false
     * }</pre>
     * Hints
     * 1. The constructor gets two city names, not a Route. It makes the Route from them with {@code new} and stores it in {@code this.route}. {@code goesTo} then asks that route where it ends, and compares the answer with the city.
     * 2. In the constructor: {@code this.passenger = passenger;} and {@code this.route = new Route(from, to);}. In {@code goesTo}: {@code return this.route.getTo().equals(city);}. Compare text with {@code equals}, not {@code ==}.
     */
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Lea", "Harbor Town", "Hill Park");
        System.out.println(ticket);
        System.out.println(ticket.goesTo("Hill Park"));
        System.out.println(ticket.goesTo("Harbor Town"));
    }
}
