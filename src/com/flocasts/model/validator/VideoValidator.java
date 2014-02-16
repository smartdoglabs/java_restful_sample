package com.flocasts.model.validator;

import com.flocasts.model.Event;
import com.flocasts.model.EventType;
import com.flocasts.model.Video;

/**
 * Created by joserubio on 2/15/14.
 */
public class VideoValidator {


    public static boolean isValid(Video video) {

        boolean result = false;

        //Check that the required fields have a value
        if( video.getTitle() != null &&
            video.getUrl() != null &&
            video.getChannels() != null ) {

            result = true;
        }

        return result;

    }
}
