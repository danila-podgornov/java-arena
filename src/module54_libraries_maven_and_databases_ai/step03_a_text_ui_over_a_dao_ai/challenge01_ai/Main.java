// AI-Generated
package module54_libraries_maven_and_databases_ai.step03_a_text_ui_over_a_dao_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * Write the text UI of the bike repair queue in {@code QueueUi.java}. The DAO from step 2 is ready in the other files, and {@code main} creates both. In {@code start}, before reading each command, print {@code > } with {@code print}. The commands:
     * <ul>
     * <li>{@code list} prints every job on a line of its own, or {@code The queue is empty} when there are none
     * <li>{@code add} reads two more lines, the bike and the problem, adds the job and prints {@code Added job } and its id
     * <li>{@code quit} prints {@code Bye} and ends
     * <li>anything else prints {@code Unknown command: } and the command
     * </ul>
     * <p>{@code QueueUi} uses only the DAO it's given. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > The queue is empty
     * > Added job 1
     * > Added job 2
     * > #1 red road bike: flat tire (waiting)
     * #2 green cargo bike: squeaky brakes (waiting)
     * > Unknown command: pump
     * > Bye
     * }</pre>
     * Hints
     * 1. Start from {@code RecipeUi}: {@code while (true)}, the prompt with {@code print}, one {@code nextLine()} for the command, {@code quit} with a {@code break}, and an {@code if} for each other command. A private method for each command keeps {@code start} short.
     * 2. {@code list} asks {@code this.queue.list()} and checks {@code isEmpty()} first. {@code add} reads the bike and the problem with two more {@code nextLine()} calls and prints the id that {@code this.queue.add} returns.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new InMemoryRepairJobDao();
        QueueUi ui = new QueueUi(queue, new Scanner(System.in));
        ui.start();
    }
}
