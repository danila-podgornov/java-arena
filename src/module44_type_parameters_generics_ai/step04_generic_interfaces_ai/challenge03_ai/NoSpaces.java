// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge03_ai;

public class NoSpaces implements Rule<String> {
    @Override
    public boolean allows(String value) {
        return !value.contains(" ");
    }
}
