// AI-Generated
package module24_lists_inside_objects_ai.step09_rules_the_owner_enforces_ai.challenge01_ai;

public class Main {
    /**
     * A day plan holds meetings, and two meetings can't be at the same time. A meeting has a title, and a start and an end hour: {@code new Meeting("Review", 10, 12)} is from 10 to 12. {@code Meeting.java} is ready, with the getters {@code getStart()} and {@code getEnd()}. In {@code DayPlan.java}, write the method {@code add(Meeting meeting)}. It adds the meeting only when it doesn't overlap any meeting already on the plan, and returns {@code true} when the meeting was added, {@code false} when it wasn't.
     * <p>Two meetings overlap when each one starts before the other one ends. A meeting from 9 to 10 and one from 10 to 12 don't overlap: the first ends just as the second starts. The check runs:
     * <pre>{@code
     * DayPlan plan = new DayPlan();
     * System.out.println(plan.add(new Meeting("Standup", 9, 10)));
     * System.out.println(plan.add(new Meeting("Review", 10, 12)));
     * System.out.println(plan.add(new Meeting("Lunch talk", 11, 13)));
     * System.out.println(plan.add(new Meeting("Call", 8, 9)));
     * System.out.println(plan);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * true
     * Booked: [Standup (9 to 10), Review (10 to 12), Call (8 to 9)]
     * }</pre>
     * Hints
     * 1. Check the rule before adding: go through the meetings already booked, and return {@code false} as soon as one of them overlaps the new one. Only after the loop, when none did, add the meeting and return {@code true}.
     * 2. In {@code for (Meeting other : this.meetings)}, the two overlap when {@code meeting.getStart() < other.getEnd() && other.getStart() < meeting.getEnd()}. With {@code <}, a meeting that starts just as another ends still fits.
     */
    public static void main(String[] args) {
        DayPlan plan = new DayPlan();
        System.out.println(plan.add(new Meeting("Standup", 9, 10)));
        System.out.println(plan.add(new Meeting("Review", 10, 12)));
        System.out.println(plan.add(new Meeting("Lunch talk", 11, 13)));
        System.out.println(plan.add(new Meeting("Call", 8, 9)));
        System.out.println(plan);
    }
}
