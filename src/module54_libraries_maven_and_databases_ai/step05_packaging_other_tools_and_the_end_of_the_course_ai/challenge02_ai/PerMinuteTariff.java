// AI-Generated
package module54_libraries_maven_and_databases_ai.step05_packaging_other_tools_and_the_end_of_the_course_ai.challenge02_ai;

public class PerMinuteTariff implements Tariff {
    private int centsPerMinute;

    public PerMinuteTariff(int centsPerMinute) {
        this.centsPerMinute = centsPerMinute;
    }

    @Override
    public int price(int minutes) {
        return minutes * this.centsPerMinute;
    }
}
