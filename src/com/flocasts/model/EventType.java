package com.flocasts.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jorubio
 * Date: 2/14/14
 * Time: 8:17 PM
 *
 * The different types of events that we can do in the system.
 */
public final class EventType {

    public static final String LOAD = "LOAD";
    public static final String PLAY = "PLAY";
    public static final String PAUSE = "PAUSE";
    public static final String STOP = "STOP";
    public static final String COMPLETE = "COMPLETE";
    public static final String ABANDON = "ABANDON";
    public static final String SHARE = "SHARE";
    public static final String RATE = "RATE";
    public static final String LIKE = "LIKE";
    public static final String DISLIKE = "DISLIKE";
    public static final String COMMENT = "COMMENT";

    public static List<String> typeList(){

        List<String> typeList = new ArrayList<String>();

        typeList.add(LOAD);
        typeList.add(PLAY);
        typeList.add(PAUSE);
        typeList.add(STOP);
        typeList.add(COMPLETE);
        typeList.add(ABANDON);
        typeList.add(SHARE);
        typeList.add(RATE);
        typeList.add(LIKE);
        typeList.add(DISLIKE);
        typeList.add(COMMENT);

        return typeList;

    }

    public static boolean isValidType(String type) {

        boolean isInTheList = typeList().contains(type);

        return isInTheList;
    }





}
