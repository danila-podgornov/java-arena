// AI-Generated
package module42_exceptions_ai.step06_exceptions_and_interfaces_ai.challenge02_ai;

public class LimitedCode implements DoorCodes {
    private String code;
    private int limit;
    private int wrong;

    public LimitedCode(String code, int limit) {
        this.code = code;
        this.limit = limit;
    }

    @Override
    public boolean isValid(String code) {
        if (this.wrong >= this.limit) {
            throw new IllegalStateException("Locked after " + this.limit + " wrong codes");
        }
        if (this.code.equals(code)) {
            return true;
        }
        this.wrong++;
        return false;
    }
}
