package com.flocasts.client;

import com.flocasts.model.User;
import com.flocasts.model.Video;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import java.util.Date;

/**
 * Created by joserubio on 2/15/14.
 */
public class UserTestClient {

    public static void main(String[] args) {

        try {

            User user = new User();

            user.setFirstName("Ana");
            user.setLastName("Torres");
            user.setEmailAddress("anatorresdds@gmail.com");
            user.setInterests("volleyball,gymnastics");
            user.setCreateDate(new Date());
            user.setLcts(new Date());



            ClientConfig clientConfig = new DefaultClientConfig();

            clientConfig.getFeatures().put(

                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            Client client = Client.create(clientConfig);

            WebResource webResource = client.resource("http://localhost:9998/users");

            ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, user);

            if (response.getStatus() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                                + response.getStatus());

            }

            String output = response.getEntity(String.class);

            System.out.println("Server response .... \n");

            System.out.println(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
