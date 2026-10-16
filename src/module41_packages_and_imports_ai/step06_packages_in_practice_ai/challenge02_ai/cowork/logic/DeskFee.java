// AI-Generated
package module41_packages_and_imports_ai.step06_packages_in_practice_ai.challenge02_ai.cowork.logic;

public class DeskFee {
    private int perHour;
    private int dailyMax;

    public DeskFee(int perHour, int dailyMax) {
        this.perHour = perHour;
        this.dailyMax = dailyMax;
    }

    public int price(int minutes) {
        int price = this.startedHours(minutes) * this.perHour;
        if (price > this.dailyMax) {
            return this.dailyMax;
        }
        return price;
    }

    int startedHours(int minutes) {
        return (minutes + 59) / 60;
    }
}
