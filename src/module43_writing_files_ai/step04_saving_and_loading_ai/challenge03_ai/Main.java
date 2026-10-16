// AI-Generated
package module43_writing_files_ai.step04_saving_and_loading_ai.challenge03_ai;

public class Main {
    /**
     * A wish list app saves its wishes when it ends. The output looks right, but after a few runs the file is full of the same wishes over and over. Find the bug in {@code Wishlist.java} and fix it, so that the file holds each wish once. With the file shown below, the program prints:
     * {@code 3 wishes saved}
     * <p>and {@code wishes.txt} should then hold {@code kite}, {@code bike} and {@code board game}, one per line.
     * Hints
     * 1. The output is right, and the file isn't. Look at how {@code save} opens the file: what does the {@code true} do there?
     * 2. {@code save} writes the whole list, the wishes that {@code load} read from the file included, so the file must be emptied first: {@code new PrintWriter(fileName)}, without the FileWriter.
     */
    public static void main(String[] args) throws Exception {
        Wishlist list = new Wishlist();
        list.load("wishes.txt");
        list.add("board game");
        list.save("wishes.txt");
        System.out.println(list.size() + " wishes saved");
    }
}
