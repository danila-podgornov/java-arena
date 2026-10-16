// AI-Generated
package module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * To close the module, a whole program goes into packages. A kayak rental's program works, but it's all in {@code Main.java}: after Main come three more classes without {@code public}. (A file may hold several classes, but only one public one, named after the file.) Split it into packages:
     * <ul>
     * <li>{@code Kayak} goes into {@code kayak/domain/Kayak.java}, in the package {@code kayak.domain}
     * <li>{@code Dock} goes into {@code kayak/logic/Dock.java}, in the package {@code kayak.logic}
     * <li>{@code TextUI} goes into {@code kayak/ui/TextUI.java}, in the package {@code kayak.ui}
     * </ul>
     * <p>{@code Main.java} then holds only Main. Each file needs its package line and the imports of what it uses, and what other packages use must be public. The program keeps printing exactly what it prints now. For the input shown: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Take kayak 1
     * > Take kayak 2
     * > Free kayaks: 1
     * > Kayak 1 is back
     * > Kayak 1 isn't out
     * > Take kayak 1
     * > Take kayak 3
     * > All kayaks are out
     * > Free kayaks: 0
     * > Bye!
     * }</pre>
     * Hints
     * 1. Start with Kayak: {@code package kayak.domain;} on the first line, then the class, with {@code public} in front of the class, its constructor and its methods, since Dock, in another package, uses them all. Then Dock, which imports {@code java.util.ArrayList} and {@code kayak.domain.Kayak}, and TextUI, which imports Scanner, Kayak and Dock.
     * 2. When javac says {@code ... is not public in ...; cannot be accessed from outside package}, add {@code public} where the message points. In the end, {@code Main.java} holds only Main, with the imports {@code java.util.Scanner}, {@code kayak.logic.Dock} and {@code kayak.ui.TextUI}.
     */
    public static void main(String[] args) {
        TextUI ui = new TextUI(new Scanner(System.in), new Dock(3));
        ui.start();
    }
}

class Kayak {
    private int number;
    private boolean out;

    Kayak(int number) {
        this.number = number;
        this.out = false;
    }

    int getNumber() {
        return this.number;
    }

    boolean isOut() {
        return this.out;
    }

    void setOut(boolean out) {
        this.out = out;
    }
}

class Dock {
    private ArrayList<Kayak> kayaks;

    Dock(int count) {
        this.kayaks = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            this.kayaks.add(new Kayak(i));
        }
    }

    Kayak rent() {
        for (Kayak kayak : this.kayaks) {
            if (!kayak.isOut()) {
                kayak.setOut(true);
                return kayak;
            }
        }
        return null;
    }

    boolean giveBack(int number) {
        for (Kayak kayak : this.kayaks) {
            if (kayak.getNumber() == number && kayak.isOut()) {
                kayak.setOut(false);
                return true;
            }
        }
        return false;
    }

    int freeCount() {
        int free = 0;
        for (Kayak kayak : this.kayaks) {
            if (!kayak.isOut()) {
                free++;
            }
        }
        return free;
    }
}

class TextUI {
    private Scanner scanner;
    private Dock dock;

    TextUI(Scanner scanner, Dock dock) {
        this.scanner = scanner;
        this.dock = dock;
    }

    void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            if (command.equals("rent")) {
                Kayak kayak = this.dock.rent();
                if (kayak == null) {
                    System.out.println("All kayaks are out");
                } else {
                    System.out.println("Take kayak " + kayak.getNumber());
                }
            } else if (command.equals("return")) {
                int number = Integer.valueOf(this.scanner.nextLine());
                if (this.dock.giveBack(number)) {
                    System.out.println("Kayak " + number + " is back");
                } else {
                    System.out.println("Kayak " + number + " isn't out");
                }
            } else if (command.equals("free")) {
                System.out.println("Free kayaks: " + this.dock.freeCount());
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
