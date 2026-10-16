// AI-Generated
package module54_libraries_maven_and_databases_ai.step03_a_text_ui_over_a_dao_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * When a bike is fixed, the mechanic marks its job as ready. Add the command {@code ready} to {@code QueueUi}: it reads one more line, a job's id. If there's no job with that id, it prints {@code No job } and the id. Otherwise it stores the job again as ready, through the DAO's {@code update}, and prints {@code Job }, the id and {@code  is ready}.
     * <p>The other commands stay as they are. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Added job 1
     * > Added job 2
     * > Job 2 is ready
     * > No job 7
     * > #1 red road bike: flat tire (waiting)
     * #2 green cargo bike: squeaky brakes (ready)
     * > Bye
     * }</pre>
     * Hints
     * 1. Add an {@code else if} for {@code ready} that calls a new private method. It reads the id with {@code Integer.valueOf(this.scanner.nextLine())} and asks {@code this.queue.findById(id)}.
     * 2. When the job is there, make {@code new RepairJob(id, job.getBike(), job.getProblem(), true)} and give it to {@code this.queue.update(...)}: the DAO's stored job changes only through the DAO.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new InMemoryRepairJobDao();
        QueueUi ui = new QueueUi(queue, new Scanner(System.in));
        ui.start();
    }
}
