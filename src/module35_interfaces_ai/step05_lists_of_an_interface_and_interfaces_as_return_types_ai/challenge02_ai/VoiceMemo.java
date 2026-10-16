// AI-Generated
package module35_interfaces_ai.step05_lists_of_an_interface_and_interfaces_as_return_types_ai.challenge02_ai;

public class VoiceMemo implements Playable {
    private String title;
    private int seconds;

    public VoiceMemo(String title, int seconds) {
        this.title = title;
        this.seconds = seconds;
    }

    @Override
    public String title() {
        return this.title;
    }

    @Override
    public int seconds() {
        return this.seconds;
    }

    @Override
    public void play() {
        System.out.println("Memo: " + this.title);
    }
}
