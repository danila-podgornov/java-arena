// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step06_layouts_inside_layouts_ai.challenge03_ai;

public class BusTime {
    private String clock;
    private String route;
    private String towards;

    public BusTime(String clock, String route, String towards) {
        this.clock = clock;
        this.route = route;
        this.towards = towards;
    }

    public static BusTime fromText(String text) {
        String[] parts = text.split(";");
        return new BusTime(parts[0], parts[1], parts[2]);
    }

    public String getClock() {
        return this.clock;
    }

    public String getRoute() {
        return this.route;
    }

    public String getTowards() {
        return this.towards;
    }

    @Override
    public String toString() {
        return this.clock + " line " + this.route + " to " + this.towards;
    }
}
