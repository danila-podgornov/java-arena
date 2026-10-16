// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step04_the_command_program_with_a_class_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * Now do the same to the bike-share station of the previous step. {@code Main.java} is its procedural version, with everything in {@code main}. Move the state and the rules into the class in {@code BikeDock.java}, and rewrite the branches of {@code main} so that they call its methods. The class needs:
     * <ul>
     * <li>{@code BikeDock(int slots, int bikes)}: a station with {@code slots} slots, {@code bikes} of which hold a bike.
     * <li>{@code rent(int count)}: if the station has at least {@code count} bikes, takes them and returns {@code true}. Otherwise it changes nothing and returns {@code false}.
     * <li>{@code bringBack(int count)}: if there are at least {@code count} free slots, puts the bikes in them and returns {@code true}. Otherwise it changes nothing and returns {@code false}.
     * <li>{@code getBikes()}: returns the number of bikes at the station.
     * <li>{@code freeSlots()}: returns the number of free slots.
     * </ul>
     * <p>The class doesn't print anything. {@code main} creates the station with {@code new BikeDock(12, 5)} and keeps no count of bikes of its own. The program prints what it did before. For the input shown: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Enjoy the ride! Bikes here: 2
     * > Sorry, bikes here: 2
     * > Thanks! Bikes here: 11
     * > Sorry, free slots: 1
     * > Bikes: 11, free slots: 1
     * > Station closed
     * }</pre>
     * Hints
     * 1. Do what the box office did: the two local variables {@code slots} and {@code bikes} become the private instance variables of BikeDock, set in its constructor. Each check in a branch moves into a method that returns {@code true} when it did what was asked and {@code false} when it refused.
     * 2. In {@code main}, create {@code BikeDock dock = new BikeDock(12, 5);} before the loop, and write the {@code rent} branch as {@code if (dock.rent(count)) { ... } else { ... }}. Where {@code main} printed {@code bikes} or {@code slots - bikes}, it now prints {@code dock.getBikes()} or {@code dock.freeSlots()}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int slots = 12;
        int bikes = 5;
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("close")) {
                System.out.println("Station closed");
                break;
            }
            if (command.equals("status")) {
                System.out.println("Bikes: " + bikes + ", free slots: " + (slots - bikes));
            } else if (command.equals("rent")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (count > bikes) {
                    System.out.println("Sorry, bikes here: " + bikes);
                } else {
                    bikes = bikes - count;
                    System.out.println("Enjoy the ride! Bikes here: " + bikes);
                }
            } else if (command.equals("return")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (bikes + count > slots) {
                    System.out.println("Sorry, free slots: " + (slots - bikes));
                } else {
                    bikes = bikes + count;
                    System.out.println("Thanks! Bikes here: " + bikes);
                }
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
