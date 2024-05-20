package org.example;

import org.example.FlightDatabase.Flight;

import javax.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "org.example.FlightService")
public class FlightServiceImpl implements FlightService {
    private static List<Ticket> tickets = new ArrayList<>();
    private static List<String> reservedFlights = new ArrayList<>();

    @Override
    public List<FlightDatabase.Flight> getAllFlights() {
        return FlightDatabase.loadFlights().stream()
                .filter(flight -> !reservedFlights.contains(flight.getFlightNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public FlightDatabase.Flight getFlightByNumber(String flightNumber) {
        List<FlightDatabase.Flight> flights = FlightDatabase.loadFlights();
        for (FlightDatabase.Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null; // Returns null if the flight is not found
    }

    @Override
    public List<FlightDatabase.Flight> searchFlights(String flightNumber, String city, String date) {
        List<FlightDatabase.Flight> flights = FlightDatabase.loadFlights();
        return flights.stream()
                .filter(flight -> (flightNumber == null || flightNumber.equals("?") || flight.getFlightNumber().equals(flightNumber))
                        && (city == null || city.equals("?") || flight.getCityFrom().equalsIgnoreCase(city) || flight.getCityTo().equalsIgnoreCase(city))
                        && (date == null || date.equals("?") || flight.getDay().equals(date)))
                .collect(Collectors.toList());
    }

    @Override
    public byte[] purchaseTicket(String passengerName, String passengerEmail, String passengerPhone, String flightNumber) {
        Flight flight = getFlightByNumber(flightNumber);
        if (flight != null && !reservedFlights.contains(flightNumber)) {
            Ticket ticket = new Ticket(passengerName, passengerEmail, passengerPhone, flight);
            tickets.add(ticket);
            reservedFlights.add(flightNumber); // Mark the flight as reserved

            try {
                return PdfGenerator.generateTicketPdf(ticket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null; // Returns null if the flight is not found or already reserved
    }

    @Override
    public byte[] getTicketPdf(String passengerEmail, String flightNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getPassengerEmail().equalsIgnoreCase(passengerEmail) &&
                    ticket.getFlightDetails().getFlightNumber().equals(flightNumber)) {
                try {
                    return PdfGenerator.generateTicketPdf(ticket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null; // Returns null if the ticket is not found
    }



    @Override
    public List<FlightDatabase.Flight> getBookedFlightsByPassengerEmail(String passengerEmail) {
        return tickets.stream()
                .filter(ticket -> ticket.getPassengerEmail().equalsIgnoreCase(passengerEmail))
                .map(Ticket::getFlightDetails)
                .collect(Collectors.toList());
    }
}
