// AI-Generated
package module56_records_ai.step04_methods_and_factories_ai.challenge02_ai;

public class Main {
    /**
     * A game shows each player as an avatar with a name, a color and a level. Saved avatars never change: a change in the settings makes a new one. In {@code Avatar.java}, add to the record {@code Avatar(String name, String color, int level)} two methods:
     * <ul>
     * <li>{@code withColor(String newColor)}, which returns a new Avatar with the same name and level and the new color;
     * <li>{@code withLevel(int newLevel)}, which returns a new Avatar with the same name and color and the new level.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Avatar saved = new Avatar("Noor", "teal", 3);
     * Avatar repainted = saved.withColor("amber");
     * Avatar promoted = repainted.withLevel(4);
     * System.out.println(saved);
     * System.out.println(repainted);
     * System.out.println(promoted);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Avatar[name=Noor, color=teal, level=3]
     * Avatar[name=Noor, color=amber, level=3]
     * Avatar[name=Noor, color=amber, level=4]
     * }</pre>
     * Hints
     * 1. Both methods return an Avatar: {@code public Avatar withColor(String newColor)}. Each returns {@code new Avatar(...)} with three values, in the order of the header.
     * 2. In {@code withColor}, copy the name and the level from this avatar, and put {@code newColor} in the middle: {@code new Avatar(this.name, newColor, this.level)}. The original avatar stays as it was: nothing in a record can change.
     */
    public static void main(String[] args) {
        Avatar saved = new Avatar("Noor", "teal", 3);
        Avatar repainted = saved.withColor("amber");
        Avatar promoted = repainted.withLevel(4);
        System.out.println(saved);
        System.out.println(repainted);
        System.out.println(promoted);
    }
}
