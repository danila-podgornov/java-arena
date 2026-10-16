// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge02_ai;

import java.util.ArrayList;

public class OneOf<T> implements Rule<T> {
    private ArrayList<T> allowed;

    public OneOf() {
        this.allowed = new ArrayList<>();
    }

    public void add(T value) {
        this.allowed.add(value);
    }

    @Override
    public boolean allows(T value) {
        return this.allowed.contains(value);
    }
}
