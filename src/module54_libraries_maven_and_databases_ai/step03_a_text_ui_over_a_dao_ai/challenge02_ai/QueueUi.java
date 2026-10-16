// AI-Generated
package module54_libraries_maven_and_databases_ai.step03_a_text_ui_over_a_dao_ai.challenge02_ai;

import java.util.List;
import java.util.Scanner;

public class QueueUi {
    private RepairJobDao queue;
    private Scanner scanner;

    public QueueUi(RepairJobDao queue, Scanner scanner) {
        this.queue = queue;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye");
                break;
            }
            if (command.equals("list")) {
                list();
            } else if (command.equals("add")) {
                add();
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    private void list() {
        List<RepairJob> jobs = this.queue.list();
        if (jobs.isEmpty()) {
            System.out.println("The queue is empty");
        }
        for (RepairJob job : jobs) {
            System.out.println(job);
        }
    }

    private void add() {
        String bike = this.scanner.nextLine();
        String problem = this.scanner.nextLine();
        int id = this.queue.add(bike, problem);
        System.out.println("Added job " + id);
    }
}
