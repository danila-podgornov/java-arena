// AI-Generated
package module42_exceptions_ai.step04_exceptions_and_resources_ai.challenge02_ai;

public class Faucet implements AutoCloseable {
    private String name;

    public Faucet(String name) {
        this.name = name;
        System.out.println(name + " on");
    }

    @Override
    public void close() {
        System.out.println(this.name + " off");
    }
}
