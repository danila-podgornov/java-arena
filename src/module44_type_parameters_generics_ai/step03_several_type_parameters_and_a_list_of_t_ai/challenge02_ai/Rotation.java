// AI-Generated
package module44_type_parameters_generics_ai.step03_several_type_parameters_and_a_list_of_t_ai.challenge02_ai;

import java.util.ArrayList;

public class Rotation<T> {
    private ArrayList<T> members;
    private int turn;

    public Rotation() {
        this.members = new ArrayList<>();
        this.turn = 0;
    }

    public void add(T member) {
        this.members.add(member);
    }

    public T next() {
        T member = this.members.get(this.turn);
        this.turn++;
        if (this.turn == this.members.size()) {
            this.turn = 0;
        }
        return member;
    }
}
