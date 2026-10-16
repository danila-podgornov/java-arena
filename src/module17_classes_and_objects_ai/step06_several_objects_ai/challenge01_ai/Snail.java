// AI-Generated
package module17_classes_and_objects_ai.step06_several_objects_ai.challenge01_ai;

public class Snail {
    private String name;
    private int distance;

    public Snail(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void crawl(int cm) {
        this.distance = this.distance + cm;
    }

    public void printDistance() {
        System.out.println(this.name + " has crawled " + this.distance + " cm");
    }
}
