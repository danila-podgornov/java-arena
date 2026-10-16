// AI-Generated
package module23_objects_working_together_ai.step01_an_object_as_a_parameter_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? Each call to {@code enter} works with two objects: the gate it's called on and the passport it's given.
     * Hints
     * 1. {@code enter} gets the passport itself, not a copy, so {@code passport.addStamp()} changes the Passport object in {@code ana} or {@code ben}. Then the gate counts one more entry of its own.
     * 2. Ana's passport is given to {@code enter} three times: twice at the north gate and once at the south gate. Ben's is given once. The north gate counted two entries, both Ana's.
     */
    public static void main(String[] args) {
        Passport ana = new Passport("Ana");
        Passport ben = new Passport("Ben");
        Gate north = new Gate("North gate");
        Gate south = new Gate("South gate");
        north.enter(ana);
        south.enter(ben);
        north.enter(ana);
        south.enter(ana);
        System.out.println(ana);
        System.out.println(ben);
        System.out.println(north);
    }
}
