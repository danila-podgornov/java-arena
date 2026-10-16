// AI-Generated
package module50_gui_multiple_views_ai.step08_a_board_of_buttons_and_the_end_of_part_13_ai.challenge02_ai;

public class NumberGrab {
    private int[][] numbers;
    private String[][] owners;
    private String turn;
    private int red;
    private int blue;
    private int taken;
    private int total;

    public NumberGrab(int[][] numbers) {
        this.numbers = numbers;
        this.owners = new String[numbers.length][numbers[0].length];
        this.turn = "Red";
        for (int[] row : numbers) {
            for (int number : row) {
                this.total += number;
            }
        }
    }

    public int numberAt(int row, int column) {
        return this.numbers[row][column];
    }

    public String ownerAt(int row, int column) {
        return this.owners[row][column];
    }

    public String turn() {
        return this.turn;
    }

    public int score(String player) {
        if (player.equals("Red")) {
            return this.red;
        }
        return this.blue;
    }

    public boolean take(int row, int column) {
        if (this.isOver() || this.owners[row][column] != null) {
            return false;
        }
        this.owners[row][column] = this.turn;
        if (this.turn.equals("Red")) {
            this.red += this.numbers[row][column];
            this.turn = "Blue";
        } else {
            this.blue += this.numbers[row][column];
            this.turn = "Red";
        }
        this.taken++;
        return true;
    }

    public boolean isOver() {
        int cells = this.numbers.length * this.numbers[0].length;
        return 2 * this.red > this.total || 2 * this.blue > this.total || this.taken == cells;
    }

    public String status() {
        if (!this.isOver()) {
            return this.turn + "'s turn";
        }
        if (this.red > this.blue) {
            return "Red wins " + this.red + " to " + this.blue;
        }
        if (this.blue > this.red) {
            return "Blue wins " + this.blue + " to " + this.red;
        }
        return "A draw: " + this.red + " each";
    }
}
