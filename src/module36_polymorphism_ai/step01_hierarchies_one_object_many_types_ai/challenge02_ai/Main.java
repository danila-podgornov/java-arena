// AI-Generated
package module36_polymorphism_ai.step01_hierarchies_one_object_many_types_ai.challenge02_ai;

public class Main {
    /**
     * The booth's truck, seen through several variables. What does this program print?
     * Hints
     * 1. {@code vehicle}, {@code customer} and {@code thing} all refer to the one Truck that the first {@code new} made. Printing {@code thing} runs the object's own {@code toString}, which is Vehicle's, and it calls the truck's {@code toll()}.
     * 2. {@code getClass().getName()} names the object's class, not the variable's type. {@code twin} is a second object, made by another {@code new}, so {@code ==} is {@code false}, even though its values are the same.
     */
    public static void main(String[] args) {
        Truck truck = new Truck("TR-88", "Nordic Freight", 2);
        Vehicle vehicle = truck;
        Commercial customer = truck;
        Object thing = customer;

        System.out.println(vehicle.toll() + " " + customer.company());
        System.out.println(thing);
        System.out.println(thing.getClass().getName());
        System.out.println(thing == vehicle);

        Vehicle twin = new Truck("TR-88", "Nordic Freight", 2);
        System.out.println(twin == vehicle);
    }
}
