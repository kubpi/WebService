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
}
