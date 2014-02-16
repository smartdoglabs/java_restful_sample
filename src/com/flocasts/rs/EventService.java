package com.flocasts.rs;

import com.flocasts.dao.EventRepository;
import com.flocasts.dao.impl.EventRepositoryHibernateImpl;
import com.flocasts.model.Event;
import com.flocasts.model.EventType;
import com.flocasts.model.validator.VideoEventValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
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

    private final EventRepository repo = new EventRepositoryHibernateImpl();
    @GET
    @Produces("application/json")
    public List<Event> getVideoEvents(@QueryParam("type") String eventType,
                                           @QueryParam("range") String eventRange) {

        log.info("Entering call to getVideoEvents");

        if( eventType == null || !EventType.isValidType(eventType) )
            return new ArrayList<Event>();

        List<Event> events = repo.loadByType(eventType,eventRange);

        return events;
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
    public Response addVideoEvent(Event event) {

        log.info("Entering call to addVideoEvent");

        //Check that the event is valid
        if(event != null && VideoEventValidator.isValid(event) ) {

            //The event is valid! We are good to go.

            //Check the timestamp. If it's not there, we need to default to now.
            //We don't want to catch this in the validation as we can still process without it.
            if( event.getTimestamp() == null )
                event.setTimestamp(new Date());

            //Just send it to the event repository for storage.
            //In real life this will go into a queue so we can process it later.
            repo.save(event);

            return Response.status(200).entity("Event posted to the server.").build();

        }
        else {

            return Response.status(400).entity("Event passed is not valid. Please check your request.").build();

        }
    }

}