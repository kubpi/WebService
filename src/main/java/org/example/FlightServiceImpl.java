package org.example;
import org.example.FlightDatabase.Flight;
import javax.jws.WebService;
import java.util.List;
import java.util.stream.Collectors;

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
    public Ticket purchaseTicket(String passengerName, String passengerEmail, String passengerPhone, String flightNumber) {
        Flight flight = getFlightByNumber(flightNumber);
        if (flight != null) {
            System.out.println(passengerName + passengerEmail + passengerPhone + flight);
            return new Ticket(passengerName, passengerEmail, passengerPhone, flight);

        }
        return null;  // Można zwrócić błąd lub wartość null, jeśli lot nie zostanie znaleziony
    }
}
