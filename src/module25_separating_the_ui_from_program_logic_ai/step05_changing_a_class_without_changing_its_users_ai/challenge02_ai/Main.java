// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * A camping program keeps a packing list. {@code PackingList} keeps two lists that must stay in step: the names of the things in one, and their weights in grams in the other. Rewrite it to keep a single {@code ArrayList<Item>}, using the ready {@code Item} class. Keep its public methods, {@code add(String name, int grams)}, {@code totalGrams()} and {@code heaviest()}, as they are: {@code Main.java}, the user interface, must work without a change. When two things weigh the same, {@code heaviest()} returns the one packed first, as the old code did. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Packed tent
     * > Packed stove
     * > Packed sleeping bag
     * > Total: 3800 grams
     * > Heaviest: tent
     * > Have a good trip!
     * }</pre>
     * Hints
     * 1. {@code add} still takes a name and a weight, but now makes one object of them: {@code this.items.add(new Item(name, grams));}.
     * 2. {@code totalGrams} adds up {@code item.getGrams()} with a for-each loop. {@code heaviest} starts from the first item, keeps the heaviest one found so far, and returns its {@code getName()}. An empty list still gives {@code nothing}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PackingList packing = new PackingList();
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("done")) {
                System.out.println("Have a good trip!");
                break;
            }
            if (command.equals("pack")) {
                String name = scanner.nextLine();
                int grams = Integer.valueOf(scanner.nextLine());
                packing.add(name, grams);
                System.out.println("Packed " + name);
            } else if (command.equals("weight")) {
                System.out.println("Total: " + packing.totalGrams() + " grams");
            } else if (command.equals("heaviest")) {
                System.out.println("Heaviest: " + packing.heaviest());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
