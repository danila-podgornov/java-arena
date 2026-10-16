// AI-Generated
package module23_objects_working_together_ai.step06_methods_that_return_objects_ai.challenge01_ai;

public class Main {
    /**
     * In {@code Route.java}, write the method {@code reversed()}. It returns a new Route for the way back: from where this route ends to where it starts. The route it's called on stays as it was. The check runs:
     * <pre>{@code
     * Route there = new Route("Harbor Town", "Hill Park");
     * Route back = there.reversed();
     * System.out.println(there);
     * System.out.println(back);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Harbor Town to Hill Park
     * Hill Park to Harbor Town
     * }</pre>
     * Hints
     * 1. The method returns a Route: <code>public Route reversed() {</code>.
     * 2. Make the new route with the ends swapped, and return it: {@code return new Route(this.to, this.from);}. Nothing in {@code this} changes.
     */
    public static void main(String[] args) {
        Route there = new Route("Harbor Town", "Hill Park");
        Route back = there.reversed();
        System.out.println(there);
        System.out.println(back);
    }
}
