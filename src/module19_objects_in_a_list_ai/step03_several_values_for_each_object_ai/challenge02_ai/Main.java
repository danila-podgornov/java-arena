// AI-Generated
package module19_objects_in_a_list_ai.step03_several_values_for_each_object_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * {@code Main.java} reads podcasts, a title and then how many episodes the podcast has, until the title is an empty line. It doesn't compile yet, because {@code Podcast} only takes a title. Change {@code Podcast} so that its constructor takes the title and the number of episodes, the object keeps both, and a podcast prints like {@code Night Sky (12 episodes)}. For the input {@code Night Sky}, {@code 12}, {@code Word Play}, {@code 40} and an empty line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Night Sky (12 episodes)
     * Word Play (40 episodes)
     * }</pre>
     * Hints
     * 1. Three changes in {@code Podcast}: a new object variable {@code private int episodes;}, a second constructor parameter {@code int episodes} that's stored with {@code this.episodes = episodes;}, and a new {@code toString}.
     * 2. {@code return this.title + " (" + this.episodes + " episodes)";}
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Podcast> podcasts = new ArrayList<>();

        while (true) {
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            }
            int episodes = Integer.valueOf(scanner.nextLine());
            podcasts.add(new Podcast(title, episodes));
        }

        for (Podcast podcast : podcasts) {
            System.out.println(podcast);
        }
    }
}
