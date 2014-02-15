package com.flocasts.rs;

import com.flocasts.dao.UserRepository;
import com.flocasts.dao.impl.UserRepositoryHibernateImpl;
import com.flocasts.model.User;
import com.flocasts.model.Video;
import com.flocasts.model.VideoEvent;
import com.flocasts.util.HibernateUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

    private static final Logger log = Logger.getLogger(VideoService.class.getName());

    private final UserRepository repo = new UserRepositoryHibernateImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@QueryParam("id") Integer userId) {

       return null;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Integer userId ){

        log.info("Entering call to getUser");

        User theUser = null;

        if( userId != null ) {
            theUser = repo.loadById(userId);
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
    public List<VideoEvent> getUserActivity(@PathParam("id") Integer userId, @QueryParam("type") String eventType ){

        log.info("Entering call to getUserActivity");

        return null;
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

        log.info("Entering call to getVideoRecommendations");

        return null;
    }

}