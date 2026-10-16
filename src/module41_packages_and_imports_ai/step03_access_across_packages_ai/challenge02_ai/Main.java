// AI-Generated
package module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge02_ai;

import module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge02_ai.vending.ads.AdScreen;

public class Main {
    /**
     * The vending company's machines get screens that scroll ads, and the ad screens get a package of their own, {@code vending.ads}. {@code Screen}, in {@code vending.domain}, is ready: it keeps the text it shows in {@code text}, which is protected, for its subclasses. A new Screen shows an empty text, {@code getText()} returns the text, and {@code clear()} empties it.
     * <p>In {@code vending/ads/AdScreen.java}, write the class {@code AdScreen}, which extends {@code Screen} (import it). It has:
     * <ul>
     * <li>a constructor {@code AdScreen(String text)}, which puts the text on the screen
     * <li>{@code public String scroll()}, which moves the text's first character to its end and returns the new text. An empty text stays empty.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * AdScreen screen = new AdScreen("Cold drinks! ");
     * System.out.println(screen.scroll());
     * System.out.println(screen.scroll());
     * System.out.println("Screen: " + screen.getText());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * old drinks! C
     * ld drinks! Co
     * Screen: ld drinks! Co
     * }</pre>
     * Hints
     * 1. After the package line comes {@code import vending.domain.Screen;}, and then <code>public class AdScreen extends Screen {</code>. {@code text} is Screen's protected variable: AdScreen may read and change it although it's in another package, because it's a subclass. The constructor puts the text there.
     * 2. In {@code scroll()}, {@code this.text.substring(1)} is the text without its first character, and {@code this.text.charAt(0)} is that character. Join them in the other order, keep the result in {@code this.text} and return it. Check {@code this.text.isEmpty()} first: an empty text has no first character.
     */
    public static void main(String[] args) {
        AdScreen screen = new AdScreen("Cold drinks! ");
        System.out.println(screen.scroll());
        System.out.println(screen.scroll());
        System.out.println("Screen: " + screen.getText());
    }
}
