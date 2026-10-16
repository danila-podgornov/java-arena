// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge03_ai;

public class PushAlert implements Notification {
    private String app;
    private String text;

    public PushAlert(String app, String text) {
        this.app = app;
        this.text = text;
    }

    @Override
    public String deliver() {
        return "[" + this.app + "] " + this.text;
    }
}
