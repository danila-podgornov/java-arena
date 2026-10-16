// AI-Generated
package module24_lists_inside_objects_ai.step08_finding_an_object_on_the_list_ai.challenge03_ai;

public class Candidate {
    private String name;
    private int votes;

    public Candidate(String name) {
        this.name = name;
        this.votes = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getVotes() {
        return this.votes;
    }

    public void addVote() {
        this.votes++;
    }

    public String toString() {
        return this.name + ", " + this.votes + " votes";
    }
}
