package com.example.demo.rest;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

    @Inject
    private Logger logger;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response doGet() {
        logger.info(">> doGet(...)");
        return Response.ok("Hello from WildFly Swarm!").build();
    }
}