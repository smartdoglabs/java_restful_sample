package com.flocasts.engine;

import com.flocasts.model.User;
import com.flocasts.model.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by joserubio on 2/15/14.
 */
public enum RecommendationEngine {

    INSTANCE;

    private final Logger log = Logger.getLogger(RecommendationEngine.class.getName());

    RecommendationEngine() {
        init();
    }

    private void init() {
        log.info("Initializing the RecommendationEngine");
    }

    public List<Video> getRecommendations(Integer userId, Integer currentVideoId, String channel) {
        return new ArrayList<Video>();
    }


}
