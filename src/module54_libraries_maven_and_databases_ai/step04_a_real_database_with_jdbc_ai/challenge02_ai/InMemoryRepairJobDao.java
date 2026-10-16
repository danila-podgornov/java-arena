// AI-Generated
package module54_libraries_maven_and_databases_ai.step04_a_real_database_with_jdbc_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepairJobDao implements RepairJobDao {
    private List<RepairJob> jobs;
    private int nextId;

    public InMemoryRepairJobDao() {
        this.jobs = new ArrayList<>();
        this.nextId = 1;
    }

    @Override
    public List<RepairJob> list() {
        return new ArrayList<>(this.jobs);
    }

    @Override
    public int add(String bike, String problem) {
        int id = this.nextId;
        this.nextId++;
        this.jobs.add(new RepairJob(id, bike, problem, false));
        return id;
    }

    @Override
    public RepairJob findById(int id) {
        for (RepairJob job : this.jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean update(RepairJob job) {
        for (int i = 0; i < this.jobs.size(); i++) {
            if (this.jobs.get(i).getId() == job.getId()) {
                this.jobs.set(i, job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(int id) {
        RepairJob job = findById(id);
        if (job == null) {
            return false;
        }
        this.jobs.remove(job);
        return true;
    }
}
