// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step03_constructors_and_super_ai.challenge03_ai;

public class Main {
    /**
     * A museum's sculptures are exhibits too, with a material of their own. Fill in the blank, so that Sculpture's constructor hands the name and the year to Exhibit's constructor.
     * Hints
     * 1. Sculpture's constructor must first call its superclass's constructor, with the name and the year.
     * 2. The word for the superclass's constructor is {@code super}: {@code super(name, year);}.
     */
    public static void main(String[] args) {
        Sculpture lion = new Sculpture("Sleeping lion", 1860, "marble");
        System.out.println(lion.getName() + ", " + lion.getYear() + ", " + lion.getMaterial());
    }
}
