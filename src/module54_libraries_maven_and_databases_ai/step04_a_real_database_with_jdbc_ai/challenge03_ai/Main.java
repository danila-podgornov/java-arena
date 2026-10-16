// AI-Generated
package module54_libraries_maven_and_databases_ai.step04_a_real_database_with_jdbc_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * Show that the UI really doesn't care which DAO it gets: write a second DAO that keeps the jobs in memory in a different way, and plug it in. {@code MapRepairJobDao} implements {@code RepairJobDao} with a {@code HashMap<Integer, RepairJob>} from each job's id to the job, and ids that grow from 1 as before.
     * <p>A HashMap doesn't keep its keys in any promised order (module 31), so {@code list()} must sort its new list by id before returning it. {@code findById}, {@code update} and {@code remove} find a job by its key, with no loop. {@code main} already gives a {@code MapRepairJobDao} to the {@code QueueUi} of step 3, which stays as it is. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Added job 1
     * > Added job 2
     * > Job 1 is ready
     * > No job 5
     * > #1 red road bike: flat tire (ready)
     * #2 green cargo bike: squeaky brakes (waiting)
     * > Bye
     * }</pre>
     * Hints
     * 1. Two instance variables: {@code Map<Integer, RepairJob> jobs = new HashMap<>()} and the next id. {@code add} puts the new job under its id; {@code findById} is {@code this.jobs.get(id)}, which is {@code null} for a missing key.
     * 2. {@code list} copies the values, {@code new ArrayList<>(this.jobs.values())}, and sorts the copy with {@code Comparator.comparing(RepairJob::getId)} (module 38). {@code update} checks {@code containsKey} first; a map's {@code remove(key)} returns the removed value, or {@code null}.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new MapRepairJobDao();
        QueueUi ui = new QueueUi(queue, new Scanner(System.in));
        ui.start();
    }
}
