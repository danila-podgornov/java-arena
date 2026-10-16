// AI-Generated
package module54_libraries_maven_and_databases_ai.step04_a_real_database_with_jdbc_ai;

public class Challenge01Ai {
    /**
     * This program builds SQL from strings, the way you shouldn't. What does it print? Look at which of the lines would remove more than one bike's job.
     * Hints
     * 1. The bike's text goes between two {@code '} characters, exactly as it is: the program adds a {@code '} before it and one after it.
     * 2. The second bike's text has {@code '} characters of its own. Write it in, then add the closing {@code '} at the end.
     */
    public static void main(String[] args) {
        String[] bikes = {"blue tandem", "x' OR 'a'='a"};
        for (String bike : bikes) {
            String sql = "DELETE FROM RepairJob WHERE bike = '" + bike + "'";
            System.out.println(sql);
        }
    }
}
