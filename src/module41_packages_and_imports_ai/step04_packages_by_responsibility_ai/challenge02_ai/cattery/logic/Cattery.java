// AI-Generated
package module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.logic;

import java.util.ArrayList;
import module41_packages_and_imports_ai.step04_packages_by_responsibility_ai.challenge02_ai.cattery.domain.Cat;

public class Cattery {
    private int pens;
    private ArrayList<Cat> cats;

    public Cattery(int pens) {
        this.pens = pens;
        this.cats = new ArrayList<>();
    }

    public void checkIn(Cat cat) {
        if (this.cats.size() >= this.pens) {
            System.out.println("No free pen for " + cat.getName());
            return;
        }
        this.cats.add(cat);
        System.out.println(cat.getName() + " checked in");
    }

    public void checkOut(String name) {
        for (Cat cat : this.cats) {
            if (cat.getName().equals(name)) {
                this.cats.remove(cat);
                System.out.println(name + " went home");
                return;
            }
        }
        System.out.println("No cat called " + name);
    }

    public int count() {
        return this.cats.size();
    }
}
