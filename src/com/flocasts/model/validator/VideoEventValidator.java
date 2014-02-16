package com.flocasts.model.validator;

import com.flocasts.model.Event;
import com.flocasts.model.EventType;

/**
 * Created by joserubio on 2/15/14.
 */
public class VideoEventValidator {


    public static boolean isValid(Event event) {

        boolean result = false;

        //Check that the required fields hava a value (userId, videoId, and type)
        if( event.getUserId() != null &&
            event.getVideoId() != null &&
            event.getType() != null ) {

            //Now we just need to check that the type passed is valid.
            String type = event.getType();
            if(EventType.isValidType(type) )
                result = true;
        }

        return result;

    }
}
