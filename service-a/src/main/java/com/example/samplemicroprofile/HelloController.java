package com.example.samplemicroprofile;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
}
