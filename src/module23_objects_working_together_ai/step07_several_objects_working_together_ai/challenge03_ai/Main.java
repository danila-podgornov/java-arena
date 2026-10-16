// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * An auction keeps the best bid so far in its instance variable {@code best}, which is {@code null} until the first bid comes in. {@code Bid.java} is ready, with the method {@code isHigherThan(Bid other)}. In {@code Auction.java}, write the method {@code offer(Bid bid)}: the bid becomes the best one when there's no best bid yet, or when it's higher than the best one. A bid that's only as high as the best one doesn't count, so the earlier bidder stays ahead. Compare the bids with {@code isHigherThan}.
     * <p>{@code Main.java} is ready: it reads bids such as {@code Mia 40} (a name and euros) until an empty line, and prints the auction before and after. For the input shown below, it prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Painting: no bids yet
     * Painting: Sam (55 euros)
     * }</pre>
     * Hints
     * 1. The bid becomes the best one in two cases: when there's no best bid yet ({@code this.best} is {@code null}), or when the bid is higher than the best one. Check for {@code null} first, so that {@code isHigherThan} is never given {@code null}.
     * 2. {@code if (this.best == null || bid.isHigherThan(this.best)) { this.best = bid; }}. With {@code ||}, the second part runs only when the first is false, that is, when there is a best bid.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auction auction = new Auction("Painting");
        System.out.println(auction);
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(" ");
            auction.offer(new Bid(parts[0], Integer.valueOf(parts[1])));
        }
        System.out.println(auction);
    }
}
