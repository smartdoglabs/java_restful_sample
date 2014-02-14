package com.flocasts.model;

import java.math.BigInteger;

/**
 * My Kick Ass Video Metrics and Recommendation System
 * User: Jose Rubio
 * Date: 2/9/14
 * Time: 7:59 PM
 *
 * The VideoEvent class holds the data about a particular video event that occurred in the system.
 * We could have made this more generic and called it Event, but for the purpose of this exercise I
 * will just focus it on videos.
 *
 * And event will be created when a user plays a video, shares a video, rates a video, etc. We will
 * hold as much information about the event as possible so we can use this data later on.
 */
public class VideoEvent {

    /**
     * The event ID.
     */
    private BigInteger id;

    /**
     * The User that initiated the event.
     */
    private User theUser;

    /**
     * The Video this event corresponds to.
     */
    private Video theVideo;

    /**
     * The type of event. Possible values are
     */
    private EventType type;


}
