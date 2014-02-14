package com.flocasts.rs;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/9/14
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/events")
public class EventService {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public String getVideos() {
        // Return some cliched textual content
        return "Hello World";
    }


}