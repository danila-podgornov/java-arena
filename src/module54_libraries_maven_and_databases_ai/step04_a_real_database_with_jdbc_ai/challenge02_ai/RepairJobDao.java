// AI-Generated
package module54_libraries_maven_and_databases_ai.step04_a_real_database_with_jdbc_ai.challenge02_ai;

import java.util.List;

public interface RepairJobDao {
    List<RepairJob> list();
    int add(String bike, String problem);
    RepairJob findById(int id);
    boolean update(RepairJob job);
    boolean remove(int id);
}
