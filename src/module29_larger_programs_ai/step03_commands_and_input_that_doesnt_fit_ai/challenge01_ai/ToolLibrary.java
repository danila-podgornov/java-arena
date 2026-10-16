// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge01_ai;

import java.util.ArrayList;

public class ToolLibrary {
    private ArrayList<Tool> tools;

    public ToolLibrary() {
        this.tools = new ArrayList<>();
    }

    public void add(Tool tool) {
        this.tools.add(tool);
    }

    public Tool find(String name) {
        for (Tool tool : this.tools) {
            if (tool.getName().equals(name)) {
                return tool;
            }
        }
        return null;
    }

    public ArrayList<Tool> tools() {
        return this.tools;
    }
}
