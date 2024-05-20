package org.example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface FlightService {
    @WebMethod
    List<FlightDatabase.Flight> getAllFlights();

    @WebMethod
    FlightDatabase.Flight getFlightByNumber(String flightNumber);

    @WebMethod
    byte[] purchaseTicket(String passengerName, String passengerEmail, String passengerPhone, String flightNumber);

    @WebMethod
    List<FlightDatabase.Flight> searchFlights(String flightNumber, String city, String date);

    @WebMethod
    List<FlightDatabase.Flight> getBookedFlightsByPassengerEmail(String passengerEmail);

    byte[] getTicketPdf(String passengerEmail, String flightNumber);
}
