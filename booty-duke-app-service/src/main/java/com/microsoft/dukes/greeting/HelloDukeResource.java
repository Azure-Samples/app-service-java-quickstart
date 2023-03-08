package com.microsoft.dukes.greeting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;

@Path("booty-duke")
public class HelloDukeResource {

    @Path("hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DukesGreetingRecord sayHello() {
        return new DukesGreetingRecord("Howdy Jakarta RESTful Web Services SE Bootstrap", LocalDate.now());
    }
}
