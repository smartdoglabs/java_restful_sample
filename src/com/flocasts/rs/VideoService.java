package com.flocasts.rs;
import com.flocasts.dao.EventRepository;
import com.flocasts.dao.VideoRepository;
import com.flocasts.dao.impl.EventRepositoryHibernateImpl;
import com.flocasts.dao.impl.VideoRepositoryHibernateImpl;
import com.flocasts.model.Event;
import com.flocasts.model.Video;
import com.flocasts.model.validator.VideoEventValidator;
import com.flocasts.model.validator.VideoValidator;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    private VideoRepository repo = new VideoRepositoryHibernateImpl();
    private EventRepository eventRepo = new EventRepositoryHibernateImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideos( @QueryParam("tags") String tags ) {

        log.info("Entering call to getVideos");

        List<Video> videos = repo.loadAll();

        return videos;
    }

    @GET
    @Path("/{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public Video getVideo( @PathParam("id") Integer videoId ) {

        log.info("Entering call to getVideo");

        if( videoId == null )
            return null;

        Video video = repo.loadById(videoId);

        return video;
    }

    @GET
    @Path("{id}/activity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getVideoActivity(@PathParam("id") Integer videoId, @QueryParam("type") String eventType ){

        log.info("Entering call to getVideoActivity");

        //The user activity can be accessed through the EventService. In this prototype, we are going to
        //go and grab it from the EventRepository directly
        List<Event> events = eventRepo.loadByVideoId(videoId, eventType);

        return events;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVideo(Video video) {

        log.info("Entering call to addVideoEvent");

        //Check that the event is valid
        if(video != null && VideoValidator.isValid(video) ) {

            //Video has all the data, save it in the DB
            repo.save(video);

            return Response.status(200).entity("Video stored on the server.").build();

        }
        else {

            return Response.status(400).entity("Video submitted is not valid. Please check your request.").build();

        }
    }

}