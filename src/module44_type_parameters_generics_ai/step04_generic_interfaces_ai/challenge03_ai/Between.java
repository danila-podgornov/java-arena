// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge03_ai;

public class Between implements Rule<Integer> {
    private int min;
    private int max;

    public Between(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean allows(Integer value) {
        return value >= this.min && value <= this.max;
    }
}
