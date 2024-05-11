package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "flight") // Opcjonalnie, definiuje nazwę elementu XML
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightDatabase {
    public static class Flight {
        @XmlElement(name = "flightNumber") // Opcjonalnie, definiuje nazwę elementu XML
        String flightNumber;
        @XmlElement(name = "cityFrom") // Opcjonalnie, definiuje nazwę elementu XML
        String cityFrom;
        @XmlElement(name = "cityTo")
        String cityTo;
        @XmlElement(name = "day")
        String day;
        @XmlElement(name = "time")
        String time;

        public Flight(String flightNumber, String cityFrom, String cityTo, String day, String time) {
            this.flightNumber = flightNumber;
            this.cityFrom = cityFrom;
            this.cityTo = cityTo;
            this.day = day;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Flight{" +
                    "flightNumber='" + flightNumber + '\'' +
                    ", cityFrom='" + cityFrom + '\'' +
                    ", cityTo='" + cityTo + '\'' +
                    ", day='" + day + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }

        public String getFlightNumber() { return flightNumber; }
        public String getCityFrom() { return cityFrom; }
        public String getCityTo() { return cityTo; }
        public String getDay() { return day; }
        public String getTime() { return time; }
    }

    public static List<Flight> loadFlights() {
        List<Flight> flights = new ArrayList<>();
        // Dodawanie przykładowych lotów
        flights.add(new Flight("FL100", "Warsaw", "London", "Monday", "08:00"));
        flights.add(new Flight("FL101", "Berlin", "Paris", "Tuesday", "09:30"));
        // Dodawanie dodatkowych przykładowych lotów
        flights.add(new Flight("FL102", "Madrid", "Rome", "Wednesday", "10:45"));
        flights.add(new Flight("FL103", "New York", "Los Angeles", "Thursday", "12:15"));
        flights.add(new Flight("FL104", "Tokyo", "Sydney", "Friday", "14:00"));
        flights.add(new Flight("FL105", "Moscow", "Dubai", "Saturday", "16:30"));
        flights.add(new Flight("FL106", "Singapore", "Hong Kong", "Sunday", "18:45"));
        flights.add(new Flight("FL107", "Shanghai", "Seoul", "Monday", "20:30"));
        flights.add(new Flight("FL108", "Bangkok", "Mumbai", "Tuesday", "22:00"));
        flights.add(new Flight("FL109", "Rio de Janeiro", "Buenos Aires", "Wednesday", "23:45"));
        flights.add(new Flight("FL110", "Cairo", "Johannesburg", "Thursday", "01:30"));
        flights.add(new Flight("FL111", "Mexico City", "Toronto", "Friday", "03:15"));
        flights.add(new Flight("FL112", "Amsterdam", "Brussels", "Saturday", "05:00"));
        flights.add(new Flight("FL113", "Vienna", "Zurich", "Sunday", "06:45"));
        flights.add(new Flight("FL114", "Hong Kong", "Taipei", "Monday", "08:30"));
        flights.add(new Flight("FL115", "Sydney", "Melbourne", "Tuesday", "10:15"));
        flights.add(new Flight("FL116", "Paris", "Barcelona", "Wednesday", "12:00"));
        flights.add(new Flight("FL117", "Los Angeles", "San Francisco", "Thursday", "13:45"));
        flights.add(new Flight("FL118", "Dubai", "Doha", "Friday", "15:30"));
        flights.add(new Flight("FL119", "Seoul", "Tokyo", "Saturday", "17:15"));
        flights.add(new Flight("FL120", "Mumbai", "Delhi", "Sunday", "19:00"));
        flights.add(new Flight("FL121", "Buenos Aires", "Santiago", "Monday", "20:45"));
        flights.add(new Flight("FL122", "Johannesburg", "Nairobi", "Tuesday", "22:30"));
        flights.add(new Flight("FL123", "Toronto", "Chicago", "Wednesday", "00:15"));
        flights.add(new Flight("FL124", "Brussels", "Luxembourg", "Thursday", "02:00"));
        flights.add(new Flight("FL125", "Zurich", "Geneva", "Friday", "03:45"));
        flights.add(new Flight("FL126", "Taipei", "Hong Kong", "Saturday", "05:30"));
        flights.add(new Flight("FL127", "Melbourne", "Brisbane", "Sunday", "07:15"));
        flights.add(new Flight("FL128", "Barcelona", "Madrid", "Monday", "09:00"));
        flights.add(new Flight("FL129", "San Francisco", "Seattle", "Tuesday", "10:45"));
        flights.add(new Flight("FL130", "Doha", "Abu Dhabi", "Wednesday", "12:30"));
        flights.add(new Flight("FL131", "Doha", "Warsaw", "Wednesday", "12:30"));
        flights.add(new Flight("FL132", "Doha", "Zurich", "Wednesday", "12:30"));
        // Dodaj więcej lotów
        return flights;
    }


    public static void main(String[] args) {
        List<Flight> flights = loadFlights();
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}
