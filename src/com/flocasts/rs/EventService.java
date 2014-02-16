package com.flocasts.rs;

import com.flocasts.model.VideoEvent;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/9/14
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/events")
public class EventService {

    private static final Logger log = Logger.getLogger(EventService.class.getName());
    @GET
    @Produces("application/json")
    public List<VideoEvent> getVideoEvents(@QueryParam("type") String eventType,
                                           @QueryParam("range") String eventRange) {

        log.info("Entering call to getVideoEvents");

        return null;
    }

    /**
     *
     * The addVideoEvent method is the entry point to add an event into the database. It will grab an event from
     * the body and dump it in the database. We will then use this to track usage, engagement, drive recommendations,
     * etc. This first release is going to just go and write the event to the database. Future releases will dump
     * the event into a queue so we can have a listener in the backend doing the processing so we can scale this
     * better.
     *
     * @param event
     * @return Response
     *
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVideoEvent(VideoEvent event) {

        log.info("Entering call to addVideoEvent");


        return null;
    }

}