package org.example;

import javax.xml.ws.Endpoint;
public class Main {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
        System.out.println("Web serwis czeka na klienta.....");
    }
}