// AI-Generated
package module54_libraries_maven_and_databases_ai.step03_a_text_ui_over_a_dao_ai.challenge01_ai;

public class RepairJob {
    private int id;
    private String bike;
    private String problem;
    private boolean ready;

    public RepairJob(int id, String bike, String problem, boolean ready) {
        this.id = id;
        this.bike = bike;
        this.problem = problem;
        this.ready = ready;
    }

    public int getId() {
        return this.id;
    }

    public String getBike() {
        return this.bike;
    }

    public String getProblem() {
        return this.problem;
    }

    public boolean isReady() {
        return this.ready;
    }

    @Override
    public String toString() {
        String state = "waiting";
        if (this.ready) {
            state = "ready";
        }
        return "#" + this.id + " " + this.bike + ": " + this.problem + " (" + state + ")";
    }
}
