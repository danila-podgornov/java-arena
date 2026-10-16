// AI-Generated
package module44_type_parameters_generics_ai.step03_several_type_parameters_and_a_list_of_t_ai.challenge02_ai;

public class Duo<A, B> {
    private A first;
    private B second;

    public Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    public Duo<B, A> swapped() {
        return new Duo<>(this.second, this.first);
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}
