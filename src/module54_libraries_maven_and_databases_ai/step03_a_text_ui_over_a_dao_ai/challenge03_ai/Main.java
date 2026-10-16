// AI-Generated
package module54_libraries_maven_and_databases_ai.step03_a_text_ui_over_a_dao_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * Two more commands for {@code QueueUi}:
     * <ul>
     * <li>{@code remove} reads a job's id from the next line and removes that job through the DAO. It prints {@code Removed job } and the id, or {@code No job } and the id when there's none.
     * <li>{@code next} prints {@code Next: } and the first job in the list that isn't ready yet, or {@code Nothing is waiting} when every job is ready (or there are none).
     * </ul>
     * <p>The other commands, {@code ready} too, stay as they are. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Added job 1
     * > Added job 2
     * > Job 1 is ready
     * > Next: #2 green cargo bike: squeaky brakes (waiting)
     * > Removed job 2
     * > No job 2
     * > Nothing is waiting
     * > Bye
     * }</pre>
     * Hints
     * 1. {@code remove} is like {@code ready}: read the id, then let the DAO do the work. Its {@code remove(id)} already returns whether the job was there.
     * 2. For {@code next}, go through {@code this.queue.list()} with a for-each loop and print the first job whose {@code isReady()} is false, then {@code return}. After the loop, nothing was waiting.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new InMemoryRepairJobDao();
        QueueUi ui = new QueueUi(queue, new Scanner(System.in));
        ui.start();
    }
}
