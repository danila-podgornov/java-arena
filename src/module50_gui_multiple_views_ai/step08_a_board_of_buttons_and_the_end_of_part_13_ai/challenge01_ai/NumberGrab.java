// AI-Generated
package module50_gui_multiple_views_ai.step08_a_board_of_buttons_and_the_end_of_part_13_ai.challenge01_ai;

public class NumberGrab {
    private int[][] numbers;
    private String[][] owners;
    private String turn;
    private int red;
    private int blue;

    public NumberGrab(int[][] numbers) {
        this.numbers = numbers;
        this.owners = new String[numbers.length][numbers[0].length];
        this.turn = "Red";
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
        if (this.owners[row][column] != null) {
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
        return true;
    }

    public boolean isOver() {
        return false;
    }

    public String status() {
        return this.turn + "'s turn";
    }
}
