package com.example.demo.resources;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.sql.Connection;

@Path("/hello")
@ApplicationScoped
public class HelloWorldEndpoint {

    @Inject
    private Logger logger;

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response doGet() {
        logger.info(">> doGet(...)");
        String message = "Hello from WildFly Swarm!";
        return Response.ok(message).build();
    }

}