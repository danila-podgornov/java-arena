// AI-Generated
package module23_objects_working_together_ai.step02_an_object_inside_an_object_ai.challenge01_ai;

public class Main {
    /**
     * A sports team has a name and a coach, and {@code Coach.java} is ready. In {@code Team.java}, add a private instance variable {@code coach} of type {@code Coach}, and change the constructor to {@code Team(String name, Coach coach)}. Then write the method {@code isCoachedBy(String coachName)}: it returns {@code true} when the team's coach has that name. Ask the coach for its name with {@code getName()}. The check runs:
     * <pre>{@code
     * Coach rosa = new Coach("Rosa", 12);
     * Team team = new Team("Hawks", rosa);
     * System.out.println(team.isCoachedBy("Rosa"));
     * System.out.println(team.isCoachedBy("Ken"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * }</pre>
     * Hints
     * 1. The new instance variable is declared like the others, with the class as its type: {@code private Coach coach;}. The constructor gets a second parameter, {@code Coach coach}, and stores it with {@code this.coach = coach;}.
     * 2. {@code isCoachedBy} asks the coach for its name and compares it with {@code equals}: {@code return this.coach.getName().equals(coachName);}.
     */
    public static void main(String[] args) {
        Coach rosa = new Coach("Rosa", 12);
        Team team = new Team("Hawks", rosa);
        System.out.println(team.isCoachedBy("Rosa"));
        System.out.println(team.isCoachedBy("Ken"));
    }
}
