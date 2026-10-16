// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step02_comparator_an_order_given_to_the_sort_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    /**
     * A phone's video app helps free up space by showing the largest videos first. {@code Video.java} is ready. In {@code Main.java}, write the method {@code largestFirst(List<Video> videos)}, which returns a <b>new</b> list of the videos, the largest first, and leaves the given list as it was. Copy the list with {@code new ArrayList<>(videos)}, and sort the copy with {@code Comparator.comparing} and {@code reversed()}. The check runs:
     * <pre>{@code
     * List<Video> videos = new ArrayList<>();
     * videos.add(new Video("concert.mp4", 240));
     * videos.add(new Video("cat.mp4", 85));
     * videos.add(new Video("fireworks.mp4", 310));
     * System.out.println(largestFirst(videos));
     * System.out.println(videos.get(0));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * [fireworks.mp4 310 MB, concert.mp4 240 MB, cat.mp4 85 MB]
     * concert.mp4 240 MB
     * }</pre>
     * Hints
     * 1. The header is {@code public static List<Video> largestFirst(List<Video> videos)}. Start with a copy, {@code List<Video> sorted = new ArrayList<>(videos);}, sort the copy, and return it.
     * 2. {@code Comparator.comparing(Video::getMegabytes)} puts the smallest first, and {@code .reversed()} after it puts the largest first: {@code sorted.sort(Comparator.comparing(Video::getMegabytes).reversed());}.
     */
    public static void main(String[] args) {
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("concert.mp4", 240));
        videos.add(new Video("cat.mp4", 85));
        videos.add(new Video("fireworks.mp4", 310));
        System.out.println(largestFirst(videos));
        System.out.println(videos.get(0));
    }

    // Write the method largestFirst here.
}
