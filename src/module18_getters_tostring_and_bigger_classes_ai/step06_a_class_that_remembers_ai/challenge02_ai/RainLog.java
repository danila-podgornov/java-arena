// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step06_a_class_that_remembers_ai.challenge02_ai;

public class RainLog {
    private int dryDays;
    private int wettest;

    public RainLog() {
        this.dryDays = 0;
        this.wettest = 0;
    }

    public void add(int mm) {
        if (mm == 0) {
            this.dryDays++;
        }
        if (mm > this.wettest) {
            this.wettest = mm;
        }
    }

    public int dryDays() {
        return this.dryDays;
    }

    public int wettest() {
        return this.wettest;
    }

    // Write longestDrySpell here, and keep what it needs up to date in add.
}
