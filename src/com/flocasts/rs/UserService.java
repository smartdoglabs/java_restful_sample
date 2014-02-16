package com.flocasts.rs;

import com.flocasts.dao.EventRepository;
import com.flocasts.dao.UserRepository;
import com.flocasts.dao.impl.EventRepositoryHibernateImpl;
import com.flocasts.dao.impl.UserRepositoryHibernateImpl;
import com.flocasts.model.User;
import com.flocasts.model.Video;
import com.flocasts.model.Event;
import com.flocasts.model.validator.UserValidator;
import com.flocasts.model.validator.VideoValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/14/14
 * Time: 9:19 PM
 *
 * The user service is the main class to manage the Users.
 */
@Path("/users")
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class.getName());

    private final UserRepository userRepo = new UserRepositoryHibernateImpl();
    private final EventRepository eventRepo = new EventRepositoryHibernateImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {

        log.info("Entering call to getUserActivity");

        //Grab the user list from the UserRepository
        List<User> users = userRepo.loadAll();

        return users;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Integer userId ){

        log.info("Entering call to getUser");

        User theUser = null;

        if( userId != null ) {
            theUser = userRepo.loadById(userId);
        }

        return theUser;

    }

    /**
     *
     * @param userId
     * @return
     *
     * This method will return a list of events the user has performed.
     */
    @GET
    @Path("{id}/activity")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getUserActivity(@PathParam("id") Integer userId, @QueryParam("type") String eventType ){

        log.info("Entering call to getUserActivity");

        //The user activity can be accessed through the EventService. In this prototype, we are going to
        //go and grab it from the EventRepository directly
        List<Event> events = eventRepo.loadByUserId(userId,eventType);

        return events;
    }

    /**
     *
     * @param userId
     * @param videoId
     * @param channel
     * @return
     *
     * The getVideoRecommendations is the service where we can get some recommendations for a user. So if a user
     * watches a video, or gets to a page with a video embded, we can call this service to get a list of
     * recommendations. The implementation will then go directly to the RecommendationEgnine to get the recommendations,
     * but in real life this engine would be deployed as a separate artifact and would be accessed through a RESTful
     * service.
     *
     */
    @GET
    @Path("{id}/recommendations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Video> getVideoRecommendations(@PathParam("id") Integer userId,
                                               @QueryParam("videoId") Integer videoId,
                                               @QueryParam("channel") String channel ) {




        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {

        log.info("Entering call to addVideoEvent");

        //Check that the event is valid
        if(user != null && UserValidator.isValid(user) ) {

            //User has all the data, save it in the DB
            userRepo.save(user);

            return Response.status(200).entity("User stored on the server.").build();

        }
        else {

            return Response.status(400).entity("User submitted is not valid. Please check your request.").build();

        }
    }

}