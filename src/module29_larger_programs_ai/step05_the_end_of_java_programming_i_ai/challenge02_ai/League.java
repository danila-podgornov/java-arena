// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Collections;

public class League {
    private ArrayList<Player> players;

    public League() {
        this.players = new ArrayList<>();
    }

    public Player find(String name) {
        for (Player player : this.players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void add(String playerName, int points) {
        Player player = this.find(playerName);
        if (player == null) {
            player = new Player(playerName);
            this.players.add(player);
        }
        player.addGame(points);
    }

    public Player leader() {
        Player leader = null;
        for (Player player : this.players) {
            if (leader == null || player.total() > leader.total()) {
                leader = player;
            }
        }
        return leader;
    }

    public ArrayList<String> playerNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Player player : this.players) {
            names.add(player.getName());
        }
        Collections.sort(names);
        return names;
    }
}
