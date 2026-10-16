// AI-Generated
package module29_larger_programs_ai.step01_from_a_description_to_a_plan_ai.challenge03_ai;

public class Main {
    /**
     * A bus timetable is being built one piece at a time. Times are written as numbers, so 615 is 6:15. {@code nextAfter} is written, and {@code count} is still a placeholder. What does this test drive print?
     * Hints
     * 1. {@code nextAfter} returns the first departure that's later than the time. Is 640 later than 640?
     * 2. When no departure is later, the loop ends and the method returns -1. {@code count} returns 0 whatever the list holds: it's a placeholder.
     */
    public static void main(String[] args) {
        Timetable bus = new Timetable();
        bus.add(615);
        bus.add(640);
        bus.add(710);
        System.out.println(bus.nextAfter(600));
        System.out.println(bus.nextAfter(640));
        System.out.println(bus.nextAfter(800));
        System.out.println(bus.count());
    }
}
