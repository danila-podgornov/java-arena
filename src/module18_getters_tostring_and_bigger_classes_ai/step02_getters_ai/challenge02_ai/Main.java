// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step02_getters_ai.challenge02_ai;

public class Main {
    /**
     * People change their phone numbers. The {@code Contact} class has getters for the name and the phone number; add a setter {@code setPhone(String phone)} that stores a new number. The check prints the number, sets a new one and prints the contact's name and number: see the expected output below.
     * Expected output
     * <pre>{@code
     * 040 123
     * Noor: 050 987
     * }</pre>
     * Hints
     * 1. A setter gives nothing back, so it's {@code void}, and it gets the new value as a parameter: <code>public void setPhone(String phone) {</code>.
     * 2. Its one line stores the parameter in the instance variable: {@code this.phone = phone;}
     */
    public static void main(String[] args) {
        Contact contact = new Contact("Noor", "040 123");
        contact.setPhone("050 987");
        System.out.println(contact.getName() + ": " + contact.getPhone());
    }
}
