// AI-Generated
package module13_lists_ai.step05_the_size_of_a_list_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * Fill in the blanks so the program prints how many photos there are, and which one was added last: see the expected output below.
     * Expected output
     * <pre>{@code
     * Photos: 4
     * Newest: pier.jpg
     * }</pre>
     * Hints
     * 1. {@code photos.size()} is the number of values in the list.
     * 2. The last index is one less than the size: {@code photos.size() - 1}.
     */
    public static void main(String[] args) {
        ArrayList<String> photos = new ArrayList<>();
        photos.add("beach.jpg");
        photos.add("dunes.jpg");
        photos.add("sunset.jpg");
        photos.add("pier.jpg");
        System.out.println("Photos: " + photos.___);
        System.out.println("Newest: " + photos.get(___));
    }
}
