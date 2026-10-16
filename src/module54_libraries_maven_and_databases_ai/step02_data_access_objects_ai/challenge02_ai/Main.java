// AI-Generated
package module54_libraries_maven_and_databases_ai.step02_data_access_objects_ai.challenge02_ai;

public class Main {
    /**
     * The repair queue needs to remove jobs: a customer took their bike home unfixed. The interface now has {@code boolean remove(int id)}, and {@code list}, {@code add} and {@code findById} are done. Write {@code remove} in {@code InMemoryRepairJobDao}: it removes the job with that id and returns {@code true}, or returns {@code false} when there's no such job.
     * <p>Ids are never handed out again: after job 3 is removed, the next new job still gets the next id, not 3. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * new id 4
     * [#1 red road bike: flat tire (waiting), #3 yellow folding bike: bent wheel (waiting), #4 black fixie: worn saddle (waiting)]
     * }</pre>
     * Hints
     * 1. {@code findById} already finds the job. If it returns {@code null}, there's nothing to remove.
     * 2. {@code this.jobs.remove(job)} removes that very object from the list. Don't touch {@code nextId}: it keeps counting up, so no id comes back.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new InMemoryRepairJobDao();
        queue.add("red road bike", "flat tire");
        queue.add("green cargo bike", "squeaky brakes");
        queue.add("yellow folding bike", "bent wheel");
        System.out.println(queue.remove(2));
        System.out.println(queue.remove(2));
        int next = queue.add("black fixie", "worn saddle");
        System.out.println("new id " + next);
        System.out.println(queue.list());
    }
}
