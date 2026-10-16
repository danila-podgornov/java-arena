// AI-Generated
package module35_interfaces_ai.step02_many_classes_many_interfaces_ai.challenge03_ai;

public class DeskLamp implements Dimmable {
    private int brightness;

    @Override
    public void setBrightness(int percent) {
        if (percent >= 75) {
            this.brightness = 100;
        } else if (percent >= 25) {
            this.brightness = 50;
        } else {
            this.brightness = 0;
        }
    }

    @Override
    public int getBrightness() {
        return this.brightness;
    }
}
