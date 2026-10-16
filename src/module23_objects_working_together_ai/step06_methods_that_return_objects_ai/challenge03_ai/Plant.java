// AI-Generated
package module23_objects_working_together_ai.step06_methods_that_return_objects_ai.challenge03_ai;

public class Plant {
    private String name;
    private int height;

    public Plant(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void grow(int cm) {
        this.height = this.height + cm;
    }

    public Plant cutting() {
        return new Plant(this.name, 5);
    }

    public String toString() {
        return this.name + ", " + this.height + " cm";
    }
}
