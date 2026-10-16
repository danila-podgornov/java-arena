// AI-Generated
package module56_records_ai.step05_class_or_record_ai.challenge03_ai;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    /**
     * A dentist's office lists the day's appointments by the hour, and appointments in the same hour in alphabetical order of the patients' names. {@code Appointment} is a record with the components {@code patient} and {@code hour}. In {@code Main.java}, write the method {@code printSchedule(ArrayList<Appointment> appointments)}, which sorts the given list itself (with {@code appointments.sort(...)}) using {@code Comparator.comparing(Appointment::hour)} and {@code thenComparing} by the patient, and then prints each appointment as the hour, a colon and the patient's name. The check runs:
     * <pre>{@code
     * ArrayList<Appointment> day = new ArrayList<>();
     * day.add(new Appointment("Otto", 11));
     * day.add(new Appointment("Selma", 9));
     * day.add(new Appointment("Leo", 11));
     * day.add(new Appointment("Eeva", 10));
     * day.add(new Appointment("Aada", 11));
     * printSchedule(day);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 9: Selma
     * 10: Eeva
     * 11: Aada
     * 11: Leo
     * 11: Otto
     * }</pre>
     * Hints
     * 1. The accessors work as method references: {@code Comparator.comparing(Appointment::hour)} compares by the hour, and {@code .thenComparing(Appointment::patient)} decides between appointments in the same hour.
     * 2. Sort with {@code appointments.sort(...)}, then print each appointment in a for-each loop: {@code appointment.hour() + ": " + appointment.patient()}.
     */
    public static void main(String[] args) {
        ArrayList<Appointment> day = new ArrayList<>();
        day.add(new Appointment("Otto", 11));
        day.add(new Appointment("Selma", 9));
        day.add(new Appointment("Leo", 11));
        day.add(new Appointment("Eeva", 10));
        day.add(new Appointment("Aada", 11));
        printSchedule(day);
    }

    public static void printSchedule(ArrayList<Appointment> appointments) {

    }
}
