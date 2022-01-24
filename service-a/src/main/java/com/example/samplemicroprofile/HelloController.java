package com.example.samplemicroprofile;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @Inject
    @ConfigProperty(name = "user")
    private String user;
    @GET
    public String sayHello() {
        return "Hello World for " + this.user;
    }



    @Timed(name = "helloMessageProcessed",
            description = "Monitor the time helloMessageProcessed Method takes",
            unit = MetricUnits.MILLISECONDS,
            absolute = true)
    @GET
    @Path("/hello-message-processed")
    public Response helloMessageProcessed() {
        return Response.ok().build();
    }

    @Metered(name = "todosGet",
            unit = MetricUnits.MILLISECONDS,
            description = "Monitor the rate events occured",
            absolute = true)
    @GET
    @Path("/todos-get")
    public Response todosGet() {
        return Response.ok().build();
    }

    @Counted(unit = MetricUnits.NONE,
            name = "helloGet",
            absolute = true,
            displayName = "hello get",
            description = "Monitor how many times helloGet method was called")
    @GET
    @Path("/hello-get")
    public Response helloGet() {
        return Response.ok().build();
    }

    @GET
    @Path("/get-int-value")
    @Gauge(unit = MetricUnits.NONE, name = "intValue", absolute = true)
    public int getIntValue() {
        return 3;
    }
}
