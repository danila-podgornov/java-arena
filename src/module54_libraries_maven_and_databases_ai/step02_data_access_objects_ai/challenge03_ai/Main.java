// AI-Generated
package module54_libraries_maven_and_databases_ai.step02_data_access_objects_ai.challenge03_ai;

public class Main {
    /**
     * A mechanic finishes a job, and the queue must show it as ready. The interface now has {@code boolean update(RepairJob job)}: it stores the job it's given in place of the stored job with the same id, at the same place in the list, and returns {@code true}; when no stored job has that id, it changes nothing and returns {@code false}. Write {@code update} in {@code InMemoryRepairJobDao}.
     * <p>A RepairJob can't be changed once it's made, so the program makes a new one with the same id, bike and problem, and {@code true} for ready. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * [#1 red road bike: flat tire (ready), #2 green cargo bike: squeaky brakes (waiting)]
     * }</pre>
     * Hints
     * 1. Go through the list by index, with a {@code for} loop from 0 to {@code size() - 1}, and compare each stored job's id with {@code job.getId()}.
     * 2. {@code this.jobs.set(i, job)} puts the new job at index {@code i}, in place of the old one, so the order stays. Return {@code true} right after it, and {@code false} after the loop.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new InMemoryRepairJobDao();
        queue.add("red road bike", "flat tire");
        queue.add("green cargo bike", "squeaky brakes");
        RepairJob job = queue.findById(1);
        RepairJob fixed = new RepairJob(job.getId(), job.getBike(), job.getProblem(), true);
        System.out.println(queue.update(fixed));
        System.out.println(queue.update(new RepairJob(9, "old town bike", "rusty chain", true)));
        System.out.println(queue.list());
    }
}
