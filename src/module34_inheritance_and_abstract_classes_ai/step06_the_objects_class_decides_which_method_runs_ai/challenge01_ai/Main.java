// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step06_the_objects_class_decides_which_method_runs_ai.challenge01_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The party again, with one change: Knight now overrides {@code describe} too. What does this program print?
     * Hints
     * 1. Each member runs its own class's methods. Lyra has Adventurer's {@code describe}, but it calls {@code this.attack()}, and Lyra is an Archer.
     * 2. Oren's {@code describe} is Knight's: it starts with Adventurer's text, with Knight's attack of 9 in it, and adds its own ending. The last line adds Oren's attack and Pip's.
     */
    public static void main(String[] args) {
        ArrayList<Adventurer> party = new ArrayList<>();
        party.add(new Adventurer("Pip"));
        party.add(new Archer("Lyra"));
        party.add(new Knight("Oren"));
        for (Adventurer member : party) {
            System.out.println(member.describe());
        }
        Adventurer last = party.get(2);
        System.out.println(last.attack() + party.get(0).attack());
    }
}
