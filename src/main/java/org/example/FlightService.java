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
}
