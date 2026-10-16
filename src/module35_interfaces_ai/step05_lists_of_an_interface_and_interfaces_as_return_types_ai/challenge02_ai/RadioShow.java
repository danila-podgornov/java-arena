// AI-Generated
package module35_interfaces_ai.step05_lists_of_an_interface_and_interfaces_as_return_types_ai.challenge02_ai;

public class RadioShow implements Playable {
    private String name;
    private int minutes;

    public RadioShow(String name, int minutes) {
        this.name = name;
        this.minutes = minutes;
    }

    @Override
    public String title() {
        return this.name;
    }

    @Override
    public int seconds() {
        return 60 * this.minutes;
    }

    @Override
    public void play() {
        System.out.println("On air: " + this.name);
    }
}
