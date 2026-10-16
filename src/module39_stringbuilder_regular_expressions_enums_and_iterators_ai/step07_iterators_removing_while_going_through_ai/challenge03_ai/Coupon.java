// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step07_iterators_removing_while_going_through_ai.challenge03_ai;

public class Coupon {
    private String code;
    private int percent;
    private int lastDay;

    public Coupon(String code, int percent, int lastDay) {
        this.code = code;
        this.percent = percent;
        this.lastDay = lastDay;
    }

    public String getCode() {
        return this.code;
    }

    public int getPercent() {
        return this.percent;
    }

    public int getLastDay() {
        return this.lastDay;
    }

    @Override
    public String toString() {
        return this.code + " (" + this.percent + "%)";
    }
}
