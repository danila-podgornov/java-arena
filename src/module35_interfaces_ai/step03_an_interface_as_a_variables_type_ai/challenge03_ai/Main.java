// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * The app has one button that controls one device, chosen when the app starts. The program reads one word, {@code fan} or {@code heater}. Declare one variable of type {@code Switchable}. If the word is {@code fan}, give it {@code new CeilingFan()}; otherwise give it {@code new Heater("bedroom", 19)}. Then, after the {@code if}, turn the device on and print it, each just once, whichever device it is. The classes are ready. With the input {@code fan}, the program prints: see the expected output below.
     * Expected output
     * {@code Ceiling fan: speed 1}
     * Hints
     * 1. {@code Switchable device = new Heater("bedroom", 19);} works as a start. Then an {@code if} gives {@code device} a new CeilingFan when the word is {@code fan}. Compare Strings with {@code equals}.
     * 2. After the {@code if}, {@code device.turnOn();} and {@code System.out.println(device);} work for either device: each object runs its own {@code turnOn} and its own {@code toString}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

    }
}
