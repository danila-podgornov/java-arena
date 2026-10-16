// AI-Generated
package module17_classes_and_objects_ai.step04_methods_of_an_object_ai.challenge03_ai;

public class Main {
    /**
     * Write the method {@code print()} for {@code Banner}: it prints the banner's text in a frame of {@code *} characters. The frame is 4 characters wider than the text, with a star and a space on each side of it. The check runs:
     * <pre>{@code
     * Banner banner = new Banner("Sale today");
     * banner.print();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * **************
     * * Sale today *
     * **************
     * }</pre>
     * Hints
     * 1. The border has {@code this.text.length() + 4} stars. Build it in a loop with {@code +=}, starting from the empty string {@code ""}.
     * 2. Print the border, then {@code "* " + this.text + " *"}, then the border again.
     */
    public static void main(String[] args) {
        Banner banner = new Banner("Sale today");
        banner.print();
    }
}
