package org.example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "buyer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Buyer {
    @XmlElement(name = "name")
    String name;
    @XmlElement(name = "surname")
    String surname;
    @XmlElement(name = "email")
    String email;
    @XmlElement(name = "flight")
    FlightDatabase.Flight flight;

    public Buyer() {}

    public Buyer(String name, String surname, String email, FlightDatabase.Flight flight) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", flight=" + flight +
                '}';
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FlightDatabase.Flight getFlight() {
        return flight;
    }

    public void setFlight(FlightDatabase.Flight flight) {
        this.flight = flight;
    }
}
