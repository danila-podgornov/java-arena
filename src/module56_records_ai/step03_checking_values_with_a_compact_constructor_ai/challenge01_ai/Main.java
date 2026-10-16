// AI-Generated
package module56_records_ai.step03_checking_values_with_a_compact_constructor_ai.challenge01_ai;

public class Main {
    /**
     * An online chess club keeps each player's nickname and rating. Nicknames are typed in carelessly, with spaces around them and capital letters here and there, but {@code " Rook99 "} and {@code "rook99"} are the same player. In {@code Player.java}, give the record {@code Player} a compact constructor that trims the nickname and turns it into small letters ({@code toLowerCase()}). The check runs:
     * <pre>{@code
     * Player typed = new Player("  Rook99 ", 1450);
     * Player stored = new Player("rook99", 1450);
     * System.out.println(typed);
     * System.out.println(typed.equals(stored));
     * System.out.println(new Player("QueenSide", 1720).nickname());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Player[nickname=rook99, rating=1450]
     * true
     * queenside
     * }</pre>
     * Hints
     * 1. Inside the record's braces, write {@code public Player { }}, with no parentheses after the name. That's the compact constructor.
     * 2. Give the parameter its tidied value: {@code nickname = nickname.trim().toLowerCase();}. Write {@code nickname}, not {@code this.nickname}; Java stores the parameter after your code runs.
     */
    public static void main(String[] args) {
        Player typed = new Player("  Rook99 ", 1450);
        Player stored = new Player("rook99", 1450);
        System.out.println(typed);
        System.out.println(typed.equals(stored));
        System.out.println(new Player("QueenSide", 1720).nickname());
    }
}
