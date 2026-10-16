// AI-Generated
package module24_lists_inside_objects_ai.step07_totals_from_the_objects_on_the_list_ai.challenge03_ai;

public class Main {
    /**
     * A workout is a list of exercises. {@code Exercise.java} is ready: an exercise has a name, a number of minutes, and the calories it burns in a minute, with the getters {@code getMinutes()} and {@code getCaloriesPerMinute()}. In {@code Workout.java}, write three methods:
     * <ul>
     * <li>{@code totalMinutes()} returns the minutes of all the exercises together.
     * <li>{@code totalCalories()} returns the calories of all the exercises together. Each exercise burns its minutes times its calories per minute.
     * <li>{@code averageMinutes()} returns the average length of an exercise as a {@code double}, or 0 for a workout with no exercises.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Workout workout = new Workout();
     * workout.add(new Exercise("rowing", 20, 8));
     * workout.add(new Exercise("cycling", 15, 7));
     * workout.add(new Exercise("stretching", 10, 3));
     * System.out.println(workout.totalMinutes());
     * System.out.println(workout.totalCalories());
     * System.out.println(workout.averageMinutes());
     * System.out.println(new Workout().averageMinutes());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 45
     * 295
     * 15.0
     * 0.0
     * }</pre>
     * Hints
     * 1. Both totals are loops over {@code this.exercises} that add to a local total. For the calories, add {@code exercise.getMinutes() * exercise.getCaloriesPerMinute()} in each round.
     * 2. {@code averageMinutes} first returns 0 when {@code this.exercises.isEmpty()}. Otherwise it returns {@code (double) this.totalMinutes() / this.exercises.size();}: without the {@code (double)}, 25 / 2 would be 12.
     */
    public static void main(String[] args) {
        Workout workout = new Workout();
        workout.add(new Exercise("rowing", 20, 8));
        workout.add(new Exercise("cycling", 15, 7));
        workout.add(new Exercise("stretching", 10, 3));
        System.out.println(workout.totalMinutes());
        System.out.println(workout.totalCalories());
        System.out.println(workout.averageMinutes());
        System.out.println(new Workout().averageMinutes());
    }
}
