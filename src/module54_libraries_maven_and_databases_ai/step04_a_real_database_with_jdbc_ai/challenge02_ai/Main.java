// AI-Generated
package module54_libraries_maven_and_databases_ai.step04_a_real_database_with_jdbc_ai.challenge02_ai;

public class Main {
    /**
     * Each call to a database's DAO is a trip to the database, and a slow program often makes far more of them than anyone expected. Count them without changing the DAO: write the class {@code CountingRepairJobDao}, which implements {@code RepairJobDao}, gets another {@code RepairJobDao} in its constructor and passes every call on to it, returning what it returns. It also counts:
     * <ul>
     * <li>{@code getReads()}: how many times {@code list} and {@code findById} were called
     * <li>{@code getWrites()}: how many times {@code add}, {@code update} and {@code remove} were called, whether or not they found the job
     * </ul>
     * <p>It works with any DAO: here an {@code InMemoryRepairJobDao}, on your own computer a {@code JdbcRepairJobDao}. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * [#1 red road bike: flat tire (waiting), #2 green cargo bike: squeaky brakes (ready)]
     * 2 reads, 3 writes
     * }</pre>
     * Hints
     * 1. Keep the DAO from the constructor in an instance variable of type {@code RepairJobDao}, next to two counters. Each method counts first, then returns what the same method of the inner DAO returns: {@code return this.inner.add(bike, problem);}.
     * 2. Don't make a DAO of your own inside the class: the counting DAO stores nothing, so it works around any DAO it's given, one in memory or one with a database.
     */
    public static void main(String[] args) {
        CountingRepairJobDao queue = new CountingRepairJobDao(new InMemoryRepairJobDao());
        queue.add("red road bike", "flat tire");
        queue.add("green cargo bike", "squeaky brakes");
        RepairJob job = queue.findById(2);
        queue.update(new RepairJob(2, job.getBike(), job.getProblem(), true));
        System.out.println(queue.list());
        System.out.println(queue.getReads() + " reads, " + queue.getWrites() + " writes");
    }
}
