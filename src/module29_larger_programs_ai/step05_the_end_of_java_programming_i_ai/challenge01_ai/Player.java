// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge01_ai;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Integer> games;

    public Player(String name) {
        this.name = name;
        this.games = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addGame(int points) {
        this.games.add(points);
    }

    public int total() {
        int total = 0;
        for (int points : this.games) {
            total += points;
        }
        return total;
    }

    public String toString() {
        return this.name + ", total " + this.total() + ", games " + this.games;
    }
}
