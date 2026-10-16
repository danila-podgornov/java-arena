// AI-Generated
package module22_primitive_and_reference_variables_ai.step02_reference_variables_ai.challenge01_ai;

public class Main {
    /**
     * What does this program print? Count the {@code new}s first: that's how many batteries there are.
     * Hints
     * 1. There are two batteries. At first {@code spare} points at the phone's battery, so both {@code phone.use(30)} and {@code spare.use(20)} use that one.
     * 2. {@code spare = camera;} points {@code spare} at the camera's battery, so {@code spare.use(10)} uses the camera's. After that, {@code phone} and {@code spare} point at different batteries.
     */
    public static void main(String[] args) {
        Battery phone = new Battery(100);
        Battery camera = new Battery(100);
        Battery spare = phone;
        phone.use(30);
        spare.use(20);
        camera.use(5);
        spare = camera;
        spare.use(10);
        System.out.println(phone);
        System.out.println(camera);
        System.out.println(phone == spare);
    }
}
