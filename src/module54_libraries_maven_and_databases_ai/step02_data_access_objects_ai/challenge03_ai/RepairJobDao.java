// AI-Generated
package module54_libraries_maven_and_databases_ai.step02_data_access_objects_ai.challenge03_ai;

import java.util.List;

public interface RepairJobDao {
    List<RepairJob> list();
    int add(String bike, String problem);
    RepairJob findById(int id);
    boolean update(RepairJob job);
    boolean remove(int id);
}
