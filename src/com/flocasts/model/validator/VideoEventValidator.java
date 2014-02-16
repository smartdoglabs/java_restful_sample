package com.flocasts.model.validator;

import com.flocasts.model.VideoEvent;

/**
 * Created by joserubio on 2/15/14.
 */
public class VideoEventValidator {


    public static boolean isValid(VideoEvent event) {

        boolean result = false;

        if( event.getUserId() != null && event.getVideoId() != null )
            result = true;

        return result;

    }
}
