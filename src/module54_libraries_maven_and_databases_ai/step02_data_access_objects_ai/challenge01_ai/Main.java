// AI-Generated
package module54_libraries_maven_and_databases_ai.step02_data_access_objects_ai.challenge01_ai;

public class Main {
    /**
     * A bike repair shop keeps a queue of repair jobs. {@code RepairJob.java} and the interface {@code RepairJobDao.java} are ready. Write the class {@code InMemoryRepairJobDao}, which keeps the jobs in a list:
     * <ul>
     * <li>{@code list()} returns a new list with every job, in the order they were added
     * <li>{@code add(bike, problem)} stores a new job that isn't ready yet, with the next id, and returns the id; the first id is 1
     * <li>{@code findById(id)} returns the job with that id, or {@code null}
     * </ul>
     * <p>Each DAO has ids of its own: a new DAO starts from 1 again. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 1 and 2
     * [#1 red road bike: flat tire (waiting), #2 green cargo bike: squeaky brakes (waiting)]
     * #2 green cargo bike: squeaky brakes (waiting)
     * null
     * }</pre>
     * Hints
     * 1. Follow the recipe box's {@code InMemoryRecipeDao}: two instance variables, a {@code List<RepairJob>} and the next id, both set in the constructor. The id variable must not be {@code static}, since each DAO counts on its own.
     * 2. {@code add} keeps the id in a variable, counts {@code nextId} up, stores {@code new RepairJob(id, bike, problem, false)} and returns the id. {@code list} returns {@code new ArrayList<>(this.jobs)}.
     */
    public static void main(String[] args) {
        RepairJobDao queue = new InMemoryRepairJobDao();
        int first = queue.add("red road bike", "flat tire");
        int second = queue.add("green cargo bike", "squeaky brakes");
        System.out.println(first + " and " + second);
        System.out.println(queue.list());
        System.out.println(queue.findById(2));
        System.out.println(queue.findById(5));
    }
}
