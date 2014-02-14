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
@Path("/videos/recommendations")
public class RecommendationService {


    @GET
    @Produces("application/json")
    public String getRecommendations() {
        // Return some cliched textual content
        return "{recommendation}";
    }


}