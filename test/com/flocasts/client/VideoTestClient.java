package com.flocasts.client;

import com.flocasts.model.Event;
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
public class VideoTestClient {

    public static void main(String[] args) {

        try {

            Video vid = new Video();

            vid.setTitle("Workout Wednesday");
            vid.setChannels("flotrack");
            vid.setUrl("http://www.youtube.com/watch?v=JoqS4aMOwy0");
            vid.setTags("track,workout,ncaa");
            vid.setCategories("workout,track");
            vid.setIsActive(true);
            vid.setCreateDate(new Date());
            vid.setLcts(new Date());



            ClientConfig clientConfig = new DefaultClientConfig();

            clientConfig.getFeatures().put(

                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            Client client = Client.create(clientConfig);

            WebResource webResource = client.resource("http://localhost:9998/videos");

            ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, vid);

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
