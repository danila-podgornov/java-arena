// AI-Generated
package module13_lists_ai.step08_searching_a_list_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A music player repeats its playlist: after the last song, it starts again from the first. Read the song titles, one per line, until {@code end}. Then read one more title: the song playing now. Print {@code Up next: } and the song that comes after it, or {@code Unknown song} when the title isn't in the playlist. When the song is in the playlist twice, go by its first place. For the input {@code Night Drive}, {@code Low Tide}, {@code Glass Garden}, {@code end} and {@code Low Tide} the program prints:
     * {@code Up next: Glass Garden}
     * <p>After {@code Glass Garden}, the next song would be {@code Night Drive}.
     * Hints
     * 1. First find the index of the song playing now: {@code int found = -1;}, and a loop that sets {@code found = i} and breaks at the first match (compare with {@code equals}).
     * 2. The next song is at {@code found + 1}. When that equals {@code playlist.size()}, there's no such index: the next song is the one at index 0.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> playlist = new ArrayList<>();

    }
}
