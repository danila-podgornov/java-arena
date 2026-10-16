// AI-Generated
package module24_lists_inside_objects_ai.step08_finding_an_object_on_the_list_ai.challenge03_ai;

public class Main {
    /**
     * An election has a list of candidates. {@code Candidate.java} is ready: a candidate has a name and a number of votes that starts at 0, with {@code getName()}, {@code getVotes()} and {@code addVote()}. In {@code Election.java}, write two methods:
     * <ul>
     * <li>{@code vote(String name)} gives one vote to the candidate with that name. A name that isn't a candidate's does nothing.
     * <li>{@code leader()} returns the candidate with the most votes. When there are no candidates, or when two or more share the most votes, there's no leader, and it returns {@code null}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Election election = new Election();
     * election.add(new Candidate("Ines"));
     * election.add(new Candidate("Omar"));
     * election.add(new Candidate("Yuki"));
     * System.out.println(election.leader());
     * election.vote("Omar");
     * election.vote("Ines");
     * election.vote("Omar");
     * election.vote("Zed");
     * System.out.println(election.leader());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * null
     * Omar, 2 votes
     * }</pre>
     * Hints
     * 1. {@code vote} goes through the candidates, and calls {@code candidate.addVote()} on the one whose name {@code equals} the name given. The vote changes the Candidate object on the list itself.
     * 2. In {@code leader}, keep the best candidate so far (starting at {@code null}) and a boolean {@code shared}. A candidate with more votes than the best becomes the best, and {@code shared} goes back to false; one with just as many votes sets {@code shared} to true. After the loop, return {@code null} if {@code shared} is true, and the best one otherwise.
     */
    public static void main(String[] args) {
        Election election = new Election();
        election.add(new Candidate("Ines"));
        election.add(new Candidate("Omar"));
        election.add(new Candidate("Yuki"));
        System.out.println(election.leader());
        election.vote("Omar");
        election.vote("Ines");
        election.vote("Omar");
        election.vote("Zed");
        System.out.println(election.leader());
    }
}
