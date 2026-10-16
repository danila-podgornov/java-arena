// AI-Generated
package module17_classes_and_objects_ai.step01_objects_you_already_know_ai.challenge03_ai;

public class Poll {
    private String question;
    private int yes;
    private int no;

    public Poll(String question) {
        this.question = question;
        this.yes = 0;
        this.no = 0;
    }

    public void voteYes() {
        this.yes = this.yes + 1;
    }

    public void voteNo() {
        this.no = this.no + 1;
    }

    public void printResult() {
        System.out.println(this.question);
        System.out.println("Yes " + this.yes + ", no " + this.no);
    }
}
