// AI-Generated
package module45_building_your_own_list_and_hash_map_ai.step08_why_lookups_stay_fast_ai.challenge02_ai;

public class Drawer {
    private String cabinet;
    private int number;

    public Drawer(String cabinet, int number) {
        this.cabinet = cabinet;
        this.number = number;
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Drawer)) {
            return false;
        }
        Drawer other = (Drawer) compared;
        return this.cabinet.equals(other.cabinet) && this.number == other.number;
    }

    @Override
    public int hashCode() {
        return this.cabinet.hashCode();
    }

    @Override
    public String toString() {
        return this.cabinet + "-" + this.number;
    }
}
