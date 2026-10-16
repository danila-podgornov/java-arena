// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step06_enums_with_fields_a_constructor_and_methods_ai.challenge02_ai;

public enum CupSize {
    SMALL(250, 3),
    MEDIUM(350, 4),
    LARGE(450, 5);

    private int milliliters;
    private int price;

    private CupSize(int milliliters, int price) {
        this.milliliters = milliliters;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public CupSize larger() {
        CupSize[] sizes = CupSize.values();
        if (this.ordinal() + 1 < sizes.length) {
            return sizes[this.ordinal() + 1];
        }
        return this;
    }
}
