// AI-Generated
package module12_finding_bugs_ai.step01_reading_a_crash_ai;

public class Challenge02Ai {
    /**
     * This program prints how many points each team member gets. It crashes when a team has no members. Change only the method {@code perMember}, so it returns 0 when {@code members} is 0. The check runs {@code printPoints(30, 0);} and expects: see the expected output below.
     * Expected output
     * {@code Each member gets 0}
     * Hints
     * 1. The crash's first {@code at} line names the method where it happened: {@code perMember}.
     * 2. Start {@code perMember} with {@code if (members == 0) { return 0; }}, before the division.
     */
    public static void main(String[] args) {
        printPoints(30, 3);
        printPoints(30, 0);
    }

    public static void printPoints(int points, int members) {
        System.out.println("Each member gets " + perMember(points, members));
    }

    public static int perMember(int points, int members) {
        return points / members;
    }
}
