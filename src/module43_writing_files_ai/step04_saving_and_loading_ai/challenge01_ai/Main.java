// AI-Generated
package module43_writing_files_ai.step04_saving_and_loading_ai.challenge01_ai;

public class Main {
    /**
     * Step 3's high scores get a class that keeps them. {@code HighScore.java} is step 3's class, and {@code ScoreBoard} keeps a list of HighScores, with {@code add} and {@code best()} ready. Write ScoreBoard's methods {@code save(String fileName)} and {@code load(String fileName)}:
     * <ul>
     * <li>{@code save} writes every score into the file as {@code player,points}, one per line, in the list's order, replacing what the file held.
     * <li>{@code load} reads such a file, and adds a HighScore for each of its lines to the board.
     * <li>Both pass exceptions on with {@code throws Exception}.
     * </ul>
     * <p>The check loads the file shown below, adds Kai's 5100 points, saves the board into the same file and prints the best score:
     * {@code Kai: 5100}
     * <p>and {@code scores.csv} then holds all three scores.
     * Hints
     * 1. {@code save} is step 3's loop in a try-with-resources, like TodoList's {@code save} above, writing each score's {@code toCsv()}. {@code load} is module 20's reading loop, like TodoList's {@code load}, splitting each line at the comma.
     * 2. {@code save}: {@code try (PrintWriter writer = new PrintWriter(fileName)) { for (HighScore score : this.scores) { writer.println(score.toCsv()); } }}. {@code load} reads with {@code try (Scanner reader = new Scanner(Paths.get(fileName)))}, splits each line with {@code split(",")}, and adds {@code new HighScore(parts[0], Integer.valueOf(parts[1]))} to {@code this.scores}.
     */
    public static void main(String[] args) throws Exception {
        ScoreBoard board = new ScoreBoard();
        board.load("scores.csv");
        board.add(new HighScore("Kai", 5100));
        board.save("scores.csv");
        System.out.println(board.best());
    }
}
