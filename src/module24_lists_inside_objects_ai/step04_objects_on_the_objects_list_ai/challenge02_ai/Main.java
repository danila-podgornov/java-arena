// AI-Generated
package module24_lists_inside_objects_ai.step04_objects_on_the_objects_list_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? A train keeps its wagons on a list, and the wagons are Wagon objects that can still change after they're attached.
     * Hints
     * 1. The list holds references to the wagons, not copies. Passengers who board wagon {@code a} after it's attached are still in the wagon the train sees, so what counts is the total when {@code print()} runs.
     * 2. {@code a} is attached twice, so the list has three places, and two of them refer to the same wagon. That wagon shows up twice, with all 35 passengers both times.
     */
    public static void main(String[] args) {
        Train train = new Train();
        Wagon a = new Wagon(1);
        Wagon b = new Wagon(2);
        train.attach(a);
        a.board(30);
        train.attach(b);
        train.attach(a);
        b.board(12);
        a.board(5);
        train.print();
        System.out.println(train.count() + " wagons");
    }
}
