// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A notification service sends three kinds of message. {@code Notification.java} is the interface from the lesson, with one method, {@code String deliver()}, which returns the message as it's sent. {@code Email.java} and {@code PushAlert.java} are ready. Write:
     * <ul>
     * <li>In {@code Sms.java}, the class {@code Sms}, which implements Notification. Its constructor is {@code Sms(String phone, String text)}, and {@code deliver()} returns {@code SMS to }, the phone number, {@code : } and the text. A text message has little room, so a text longer than 20 characters is cut to its first 20 characters, followed by {@code ...}.
     * <li>In {@code Main.java}, the method {@code sendAll(ArrayList<Notification> outbox)}, which prints what each notification delivers, one per line, and then how many were sent, like {@code 4 sent}.
     * </ul>
     * <p>{@code sendAll} shouldn't care which kind each notification is. The check runs:
     * <pre>{@code
     * ArrayList<Notification> outbox = new ArrayList<>();
     * outbox.add(new Email("ada@example.com", "Your invoice"));
     * outbox.add(new Sms("555-0142", "Your code is 4417"));
     * outbox.add(new PushAlert("Weather", "Rain at 3 pm"));
     * outbox.add(new Sms("555-0199", "Table for 4 is ready at the front desk"));
     * sendAll(outbox);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Email to ada@example.com: Your invoice
     * SMS to 555-0142: Your code is 4417
     * [Weather] Rain at 3 pm
     * SMS to 555-0199: Table for 4 is ready...
     * 4 sent
     * }</pre>
     * Hints
     * 1. Sms starts <code>public class Sms implements Notification {</code>, keeps the phone and the text in private variables, and writes {@code deliver()} with {@code @Override}. When {@code text.length() > 20}, use {@code text.substring(0, 20) + "..."} in place of the text.
     * 2. {@code sendAll} goes through the outbox with a for-each loop over {@code Notification}s, prints {@code notification.deliver()} for each, and after the loop prints {@code outbox.size() + " sent"}. Each object's own {@code deliver()} does the rest.
     */
    public static void main(String[] args) {
        ArrayList<Notification> outbox = new ArrayList<>();
        outbox.add(new Email("ada@example.com", "Your invoice"));
        outbox.add(new Sms("555-0142", "Your code is 4417"));
        outbox.add(new PushAlert("Weather", "Rain at 3 pm"));
        outbox.add(new Sms("555-0199", "Table for 4 is ready at the front desk"));
        sendAll(outbox);
    }

    // Write the method sendAll here.
}
