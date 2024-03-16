package org.example;

//Service Implementation
import javax.jws.WebService;
@WebService(endpointInterface = "org.example.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }
}

