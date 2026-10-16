// AI-Generated
package module43_writing_files_ai.step04_saving_and_loading_ai.challenge03_ai;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Wishlist {
    private ArrayList<String> wishes;

    public Wishlist() {
        this.wishes = new ArrayList<>();
    }

    public void add(String wish) {
        this.wishes.add(wish);
    }

    public int size() {
        return this.wishes.size();
    }

    public void save(String fileName) throws Exception {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            for (String wish : this.wishes) {
                writer.println(wish);
            }
        }
    }

    public void load(String fileName) throws Exception {
        try (Scanner reader = new Scanner(Paths.get(fileName))) {
            while (reader.hasNextLine()) {
                this.wishes.add(reader.nextLine());
            }
        }
    }
}
