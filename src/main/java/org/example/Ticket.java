package org.example;

import org.example.FlightDatabase.Flight;

public class Ticket {
    private String passengerName;
    private String passengerEmail;
    private String passengerPhone;
    private Flight flightDetails;

    public Ticket(String passengerName, String passengerEmail, String passengerPhone, Flight flightDetails) {
        this.passengerName = passengerName;
        this.passengerEmail = passengerEmail;
        this.passengerPhone = passengerPhone;
        this.flightDetails = flightDetails;
    }

    // Getters and Setters
    public String getPassengerName() { return passengerName; }
    public void setPassengerName(String passengerName) { this.passengerName = passengerName; }

    public String getPassengerEmail() { return passengerEmail; }
    public void setPassengerEmail(String passengerEmail) { this.passengerEmail = passengerEmail; }

    public String getPassengerPhone() { return passengerPhone; }
    public void setPassengerPhone(String passengerPhone) { this.passengerPhone = passengerPhone; }

    public Flight getFlightDetails() { return flightDetails; }
    public void setFlightDetails(Flight flightDetails) { this.flightDetails = flightDetails; }
}
