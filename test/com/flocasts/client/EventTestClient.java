package com.flocasts.client;

import com.flocasts.model.VideoEvent;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Created by joserubio on 2/15/14.
 */
public class EventTestClient {

    public static void main(String[] args) {

        try {

            VideoEvent ev = new VideoEvent();

            ev.setSessionId("12345");
            ev.setUserId(1);
            ev.setVideoId(1);


            ClientConfig clientConfig = new DefaultClientConfig();

            clientConfig.getFeatures().put(

                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

            Client client = Client.create(clientConfig);

            WebResource webResource = client.resource("http://localhost:9998/events");

            ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, ev);

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
