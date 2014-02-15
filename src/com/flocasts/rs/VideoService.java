package com.flocasts.rs;
import com.flocasts.model.Video;
import com.flocasts.model.VideoEvent;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/15/14
 * Time: 2:19 PM
 * The VideoService class is the entry point into the video service. HEre you can do operations like getting a list of videos,
 * getting the info for one video, get similar videos (recommendations) based on the current video.
 */

@Path("/videos")
public class VideoService {

    private static final Logger log = Logger.getLogger(VideoService.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideos( @QueryParam("tags") String tags ) {

        log.info("Entering call to getVideos");

        return null;
    }

    @GET
    @Path("/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Video getVideo( @PathParam("id") String videoId ) {

        log.info("Entering call to getVideo");

        return null;
    }

    @GET
    @Path("{id}/activity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<VideoEvent> getVideoActivity(@PathParam("id") Integer videoId, @QueryParam("type") String eventType ){

        log.info("Entering call to getVideoActivity");

        return null;
    }

    @GET
    @Path("{id}/stats")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVideoStatistics(@PathParam("id") Integer videoId, @QueryParam("range") String statRange ){

        log.info("Entering call to getVideoActivity");

        return null;
    }

    @GET
    @Path("{id}/similar")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getSimilarVideos(@PathParam("id") Integer videoId, @QueryParam("range") String statRange ){

        log.info("Entering call to getVideoActivity");

        return null;
    }

}