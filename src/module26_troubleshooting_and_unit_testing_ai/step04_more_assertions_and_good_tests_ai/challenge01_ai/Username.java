// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step04_more_assertions_and_good_tests_ai.challenge01_ai;

public class Username {
    private String name;

    public Username(String name) {
        this.name = name;
    }

    public boolean isValid() {
        if (this.name.length() < 3 || this.name.length() > 12) {
            return false;
        }
        return !this.name.contains(" ");
    }
}
