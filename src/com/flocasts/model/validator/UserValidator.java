package com.flocasts.model.validator;

import com.flocasts.model.User;
import com.flocasts.model.Video;

/**
 * Created by joserubio on 2/15/14.
 */
public class UserValidator {


    public static boolean isValid(User user) {

        boolean result = false;

        //Check that the required fields have a value
        if( user.getEmailAddress() != null ) {

            result = true;
        }

        return result;

    }
}
