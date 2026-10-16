// AI-Generated
package module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.ui;

import java.util.Scanner;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.domain.Player;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.domain.Question;
import module41_packages_and_imports_ai.step05_a_larger_program_across_packages_ai.challenge01_ai.quiz.logic.Quiz;

public class TextUI {
    private Scanner scanner;
    private Quiz quiz;

    public TextUI(Scanner scanner, Quiz quiz) {
        this.scanner = scanner;
        this.quiz = quiz;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            if (command.equals("add")) {
                this.addQuestion();
            } else if (command.equals("play")) {
                this.play();
            } else if (command.equals("best")) {
                this.printBest();
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    private void addQuestion() {
        String prompt = this.scanner.nextLine();
        String answer = this.scanner.nextLine();
        int points = Integer.valueOf(this.scanner.nextLine());
        this.quiz.addQuestion(new Question(prompt, answer, points));
        System.out.println("Questions: " + this.quiz.getQuestions().size());
    }

    private void play() {
        String name = this.scanner.nextLine();
        Player player = this.quiz.newPlayer(name);
        for (Question question : this.quiz.getQuestions()) {
            System.out.println(question);
            String reply = this.scanner.nextLine();
            if (this.quiz.answer(player, question, reply)) {
                System.out.println("Right!");
            } else {
                System.out.println("Not quite.");
            }
        }
        System.out.println(player);
    }

    private void printBest() {
        Player best = this.quiz.best();
        if (best == null) {
            System.out.println("No one has played yet");
        } else {
            System.out.println("Best: " + best);
        }
    }
}
