package dev.chaepanyaprogramming.demo;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage() {
        return "Welcome to Chaepanya Spring Boot Web Application!";
    }
}
