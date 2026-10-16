// AI-Generated
package module35_interfaces_ai.step02_many_classes_many_interfaces_ai.challenge03_ai;

public class CeilingLight implements Dimmable {
    private int brightness;

    @Override
    public void setBrightness(int percent) {
        if (percent < 0) {
            this.brightness = 0;
        } else if (percent > 100) {
            this.brightness = 100;
        } else {
            this.brightness = percent;
        }
    }

    @Override
    public int getBrightness() {
        return this.brightness;
    }
}
