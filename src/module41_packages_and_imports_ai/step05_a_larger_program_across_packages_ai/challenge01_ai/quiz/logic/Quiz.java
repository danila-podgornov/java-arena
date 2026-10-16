// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.domain.Player;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.domain.Question;

public class Quiz {
    private ArrayList<Question> questions;
    private ArrayList<Player> players;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public ArrayList<Question> getQuestions() {
        return this.questions;
    }

    public Player newPlayer(String name) {
        Player player = new Player(name);
        this.players.add(player);
        return player;
    }

    public boolean answer(Player player, Question question, String reply) {
        if (question.isRight(reply)) {
            player.addPoints(question.getPoints());
            return true;
        }
        return false;
    }

    public Player best() {
        Player best = null;
        for (Player player : this.players) {
            if (best == null || player.getPoints() > best.getPoints()) {
                best = player;
            }
        }
        return best;
    }
}
