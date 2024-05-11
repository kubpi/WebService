package org.example;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "org.example.FlightService")
public class FlightServiceImpl implements FlightService {
    @Override
    public List<FlightDatabase.Flight> getAllFlights() {
        return FlightDatabase.loadFlights();
    }

    @Override
    public FlightDatabase.Flight getFlightByNumber(String flightNumber) {
        List<FlightDatabase.Flight> flights = FlightDatabase.loadFlights();
        for (FlightDatabase.Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null; // Zwraca null, jeśli nie znajdzie lotu o danym numerze
    }
}
