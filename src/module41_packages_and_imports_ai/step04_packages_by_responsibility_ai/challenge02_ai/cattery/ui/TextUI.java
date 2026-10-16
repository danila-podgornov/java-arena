// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.ui;

import java.util.Scanner;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.domain.Cat;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.logic.Cattery;

public class TextUI {
    private Scanner scanner;
    private Cattery cattery;

    public TextUI(Scanner scanner, Cattery cattery) {
        this.scanner = scanner;
        this.cattery = cattery;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            if (command.equals("in")) {
                String name = this.scanner.nextLine();
                this.cattery.checkIn(new Cat(name));
            } else if (command.equals("out")) {
                String name = this.scanner.nextLine();
                this.cattery.checkOut(name);
            } else if (command.equals("count")) {
                System.out.println("Cats: " + this.cattery.count());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
