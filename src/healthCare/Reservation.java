package healthCare;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private Date date;
    private Patient patient;
    private String reason;
    private Doctor doctor;

    // A list to manage reservations (assuming a single Hospital context)
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    // Constructor
    public Reservation(Date date, Patient patient, String reason, Doctor doctor) {
        this.date = date;
        this.patient = patient;
        this.reason = reason;
        this.doctor = doctor;
    }

    public Reservation() {
        // Default constructor
    }

    // Getters and Setters
    public Date getDate() {

        return date;
    }

    public void setDate(Date date) {

        this.date = date;
    }

    public Patient getPatient() {

        return patient;
    }

    public void setPatient(Patient patient) {

        this.patient = patient;
    }

    public String getVisitReason() {

        return visitReason;
    }

    public void setVisitReason(String visitReason) {

        this.getVisitReason = visitReason;
    }

    public Doctor getDoctor() {

        return doctor;
    }

    public void setDoctor(Doctor doctor) {

        this.doctor = doctor;
    }

    // Methods
    public void changeDoctor(Doctor doctor) {
        this.doctor = doctor;
        System.out.println("Doctor has been changed to: " + doctor.getName());
    }

    public void switchDate(Date date) {
        this.date = date;
        System.out.println("Reservation date has been switched to: " + date);
    }
    public void postpone() {
        // Logic to postpone the reservation date
        // For simplicity, assuming it postpones by one day
        long currentTime = this.date.getTime();
        this.date = new Date(currentTime + (1000 * 60 * 60 * 24)); // Adding 1 day to the current date
        System.out.println("Reservation has been postponed to: " + this.date);
    }

    public void updateFees() {
        // Placeholder for updating reservation fees
        System.out.println("Updating fees for the reservation with doctor: " + doctor.getName());
    }

    // New Methods for adding and removing reservations
    public static void addReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation added for patient: " + reservation.getPatient().getName());
    }

    public static void removeReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            System.out.println("Reservation removed for patient: " + reservation.getPatient().getName());
        } else {
            System.out.println("Reservation not found.");
        }
    }

    // Method to display all reservations (for testing purposes)
    public static void displayReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation res : reservations) {
                System.out.println("Reservation for " + res.getPatient().getName() +
                        " with Doctor " + res.getDoctor().getName() + " on " + res.getDate());
            }
        }
    }
}