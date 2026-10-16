// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step06_a_class_that_remembers_ai.challenge03_ai;

public class RainLog {
    private int dryDays;
    private int wettest;
    private int currentSpell;
    private int longestSpell;

    public RainLog() {
        this.dryDays = 0;
        this.wettest = 0;
        this.currentSpell = 0;
        this.longestSpell = 0;
    }

    public void add(int mm) {
        if (mm == 0) {
            this.dryDays++;
            this.currentSpell++;
            if (this.currentSpell > this.longestSpell) {
                this.longestSpell = this.currentSpell;
            }
        } else {
            this.currentSpell = 0;
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

    public int longestDrySpell() {
        return this.longestSpell;
    }
}
