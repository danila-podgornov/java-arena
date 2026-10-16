// AI-Generated
package module56_records_ai.step03_checking_values_with_a_compact_constructor_ai.challenge02_ai;

public class Main {
    /**
     * A download manager shows how far each file has come as a percentage. A buggy server sometimes reports values below 0 or above 100. In {@code Download.java}, give the record {@code Download(String file, int percent)} a compact constructor that keeps the percentage between 0 and 100: a value below 0 becomes 0, a value above 100 becomes 100, and anything else stays as it is. The check runs:
     * <pre>{@code
     * System.out.println(new Download("song.mp3", 64));
     * System.out.println(new Download("map.pdf", -3));
     * System.out.println(new Download("film.mkv", 140));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Download[file=song.mp3, percent=64]
     * Download[file=map.pdf, percent=0]
     * Download[file=film.mkv, percent=100]
     * }</pre>
     * Hints
     * 1. Write {@code public Download { ... }} inside the record. In it, {@code percent} is the parameter, and whatever value it has at the end is what the record keeps.
     * 2. Two ifs: {@code if (percent < 0) { percent = 0; }} and the same for above 100. {@code Math.max} and {@code Math.min} would do it in one line too: {@code percent = Math.max(0, Math.min(100, percent));}.
     */
    public static void main(String[] args) {
        System.out.println(new Download("song.mp3", 64));
        System.out.println(new Download("map.pdf", -3));
        System.out.println(new Download("film.mkv", 140));
    }
}
