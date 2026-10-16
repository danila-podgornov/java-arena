// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge03_ai;

public class MinLength implements Rule<String> {
    private int min;

    public MinLength(int min) {
        this.min = min;
    }

    @Override
    public boolean allows(String value) {
        return value.length() >= this.min;
    }
}
