// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step05_calling_the_objects_own_methods_ai.challenge03_ai;

public class Frog {
    private int hops;

    public Frog() {
        this.hops = 0;
    }

    public void hop() {
        this.hops++;
        System.out.println("hop " + this.hops);
    }

    public void hopMany(int times) {
        for (int i = 0; i < times; i++) {
            this.hop();
        }
        System.out.println("rest after " + times);
    }

    public int getHops() {
        return this.hops;
    }
}
