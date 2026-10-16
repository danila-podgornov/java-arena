// AI-Generated
package module54_libraries_maven_and_databases_ai.step03_a_text_ui_over_a_dao_ai.challenge01_ai;

import java.util.List;

public interface RepairJobDao {
    List<RepairJob> list();
    int add(String bike, String problem);
    RepairJob findById(int id);
    boolean update(RepairJob job);
    boolean remove(int id);
}
