package com.flocasts.rs;

import com.flocasts.dao.UserRepository;
import com.flocasts.dao.impl.UserRepositoryHibernateImpl;
import com.flocasts.model.User;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/14/14
 * Time: 6:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Path("/users")
public class UserService {

    @GET
    @Produces("application/json")
    public String getUsers() {

        UserRepository repo = new UserRepositoryHibernateImpl();

        User user = new User();
        user.setFirstName("Jose");
        user.setLastName("Rubio");

        repo.save(user);

        // Return some cliched textual content
        return "Hello World";
    }


}