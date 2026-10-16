// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step03_the_programs_logic_in_a_class_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * Here's the campsite of the previous step, split in two. {@code Main.java} is the user interface, and it's ready. Write the logic class in {@code Campsite.java}:
     * <ul>
     * <li>{@code Campsite(int spots)}: an empty campsite with that many tent spots.
     * <li>{@code checkIn()}: if a spot is free, one more spot is taken and the method returns {@code true}. If every spot is taken, nothing changes and it returns {@code false}.
     * <li>{@code checkOut()}: if a spot is taken, it's free again and the method returns {@code true}. If no spot is taken, nothing changes and it returns {@code false}.
     * <li>{@code freeSpots()}: returns the number of free spots.
     * </ul>
     * <p>The class doesn't print anything: {@code main} does. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Welcome! Free spots: 2
     * > Welcome! Free spots: 1
     * > Free spots: 1
     * > Welcome! Free spots: 0
     * > Sorry, the campsite is full
     * > Safe travels! Free spots: 1
     * > Lights out
     * }</pre>
     * Hints
     * 1. The campsite remembers two numbers: how many spots it has, given to the constructor, and how many are taken, which starts at 0. {@code freeSpots()} works out its answer from those two.
     * 2. In {@code checkIn()}, return {@code false} first when {@code this.taken >= this.spots}. Otherwise add one and return {@code true}. {@code checkOut()} works the same way, with {@code this.taken == 0}. {@code freeSpots()} returns {@code this.spots - this.taken}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Campsite campsite = new Campsite(3);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Lights out");
                break;
            }
            if (command.equals("arrive")) {
                if (campsite.checkIn()) {
                    System.out.println("Welcome! Free spots: " + campsite.freeSpots());
                } else {
                    System.out.println("Sorry, the campsite is full");
                }
            } else if (command.equals("depart")) {
                if (campsite.checkOut()) {
                    System.out.println("Safe travels! Free spots: " + campsite.freeSpots());
                } else {
                    System.out.println("Nobody is camping");
                }
            } else if (command.equals("spots")) {
                System.out.println("Free spots: " + campsite.freeSpots());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
