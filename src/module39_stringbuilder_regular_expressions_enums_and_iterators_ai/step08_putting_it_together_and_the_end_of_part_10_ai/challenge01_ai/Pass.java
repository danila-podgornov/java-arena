// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step08_putting_it_together_and_the_end_of_part_10_ai.challenge01_ai;

public enum Pass {
    DAY(45),
    WEEKEND(110),
    BACKSTAGE(250);

    private int price;

    private Pass(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
