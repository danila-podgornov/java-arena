// AI-Generated
package module38_ordering_objects_comparable_and_comparator_ai.step03_several_criteria_and_sorted_streams_ai.challenge02_ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    /**
     * A warehouse lists its crates by weight, and crates of the same weight by the code of the port they're shipped to. The port codes are Strings, such as {@code NLRTM} for Rotterdam. What does this program print?
     * Hints
     * 1. The first sort puts the light crates first, and the two 500 kg crates by port code, from A to Z: ESVLC before NLRTM.
     * 2. In the second sort, {@code reversed()} turns around only the weight, so the heavy crates come first, and the port codes still go from A to Z. In the third, {@code reversed()} at the end turns around both: the heavy ones first, and the port codes from Z to A.
     */
    public static void main(String[] args) {
        List<Crate> crates = new ArrayList<>();
        crates.add(new Crate("ESVLC", 500));
        crates.add(new Crate("BEANR", 1200));
        crates.add(new Crate("NLRTM", 500));
        crates.add(new Crate("DEHAM", 1200));

        crates.sort(Comparator.comparing(Crate::getKilos).thenComparing(Crate::getPort));
        System.out.println(crates.get(0) + ", " + crates.get(1));

        crates.sort(Comparator.comparing(Crate::getKilos).reversed().thenComparing(Crate::getPort));
        System.out.println(crates.get(0) + ", " + crates.get(1));

        crates.sort(Comparator.comparing(Crate::getKilos).thenComparing(Crate::getPort).reversed());
        System.out.println(crates.get(0) + ", " + crates.get(1));
    }
}
