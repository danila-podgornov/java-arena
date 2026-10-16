// AI-Generated
package module44_type_parameters_generics_ai.step01_why_type_parameters_ai.challenge03_ai;

public class Main {
    /**
     * A sports club's trophies pass from holder to holder. The chess trophy goes to a player, given by name. The relay shield goes to a team, given by its number. In {@code Trophy.java}, write the class {@code Trophy<T>} with:
     * <ul>
     * <li>a constructor {@code Trophy(String name, T holder)}: the trophy's name and its first holder
     * <li>{@code getHolder()}, which returns the current holder
     * <li>{@code passTo(T newHolder)}, which makes {@code newHolder} the holder, and returns the holder before it
     * <li>{@code toString()}, which returns the trophy's name, a colon and the holder, like {@code Chess Cup: Ravi}
     * </ul>
     * <p>The name is always a String; only the holder's type changes. The check runs:
     * <pre>{@code
     * Trophy<String> chess = new Trophy<String>("Chess Cup", "Ada");
     * String before = chess.passTo("Ravi");
     * System.out.println(before + " passed it on");
     * System.out.println(chess);
     * Trophy<Integer> relay = new Trophy<Integer>("Relay Shield", 4);
     * int old = relay.passTo(7);
     * System.out.println(old + relay.getHolder());
     * System.out.println(relay);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Ada passed it on
     * Chess Cup: Ravi
     * 11
     * Relay Shield: 7
     * }</pre>
     * Hints
     * 1. The header is {@code public class Trophy<T>}. The class has two instance variables: {@code private String name;} and {@code private T holder;}. The constructor is {@code public Trophy(String name, T holder)}, without {@code <T>}.
     * 2. {@code passTo} returns a T and takes a T: {@code public T passTo(T newHolder)}. Keep the old holder in a variable first, {@code T previous = this.holder;}, then set the new one, and return {@code previous}.
     */
    public static void main(String[] args) {
        Trophy<String> chess = new Trophy<String>("Chess Cup", "Ada");
        String before = chess.passTo("Ravi");
        System.out.println(before + " passed it on");
        System.out.println(chess);
        Trophy<Integer> relay = new Trophy<Integer>("Relay Shield", 4);
        int old = relay.passTo(7);
        System.out.println(old + relay.getHolder());
        System.out.println(relay);
    }
}
