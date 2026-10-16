// AI-Generated
package module42_exceptions_ai.step06_exceptions_and_interfaces_ai.challenge03_ai;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class DailyCode implements DoorCodes {
    private String fileName;

    public DailyCode(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public boolean isValid(String code) throws Exception {
        try (Scanner scanner = new Scanner(Paths.get(this.fileName))) {
            return scanner.nextLine().equals(code);
        }
    }
}
