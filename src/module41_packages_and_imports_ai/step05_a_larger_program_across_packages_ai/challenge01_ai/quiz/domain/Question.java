// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.domain;

public class Question {
    private String prompt;
    private String answer;
    private int points;

    public Question(String prompt, String answer, int points) {
        this.prompt = prompt;
        this.answer = answer;
        this.points = points;
    }

    public boolean isRight(String reply) {
        return reply.trim().equalsIgnoreCase(this.answer);
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return this.prompt + " (" + this.points + " points)";
    }
}
