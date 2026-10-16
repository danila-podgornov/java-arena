// AI-Generated
package module24_lists_inside_objects_ai.step07_totals_from_the_objects_on_the_list_ai.challenge02_ai;

import java.util.ArrayList;

public class Squad {
    private ArrayList<Player> players;

    public Squad() {
        this.players = new ArrayList<>();
    }

    public void add(Player player) {
        this.players.add(player);
    }

    public int totalGoals() {
        int total = 0;
        for (Player player : this.players) {
            total = total + player.getGoals();
        }
        return total;
    }

    public double averageGoals() {
        return this.totalGoals() / this.players.size();
    }
}
