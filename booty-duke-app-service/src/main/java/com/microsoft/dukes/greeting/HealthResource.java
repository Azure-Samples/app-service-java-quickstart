package com.microsoft.dukes.greeting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("")
public class HealthResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DukesGreetingRecord sayHello() {
        return new DukesGreetingRecord("Health check", LocalDate.now());
    }
}
