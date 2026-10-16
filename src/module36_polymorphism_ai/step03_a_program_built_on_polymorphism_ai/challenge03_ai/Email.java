// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge03_ai;

public class Email implements Notification {
    private String address;
    private String subject;

    public Email(String address, String subject) {
        this.address = address;
        this.subject = subject;
    }

    @Override
    public String deliver() {
        return "Email to " + this.address + ": " + this.subject;
    }
}
