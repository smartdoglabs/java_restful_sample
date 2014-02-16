package com.flocasts.dao;

import com.flocasts.model.Video;

import java.util.List;

/**
 * Created by joserubio on 2/14/14.
 */
public interface VideoRepository {

    public Video save(Video video);
    public void update(Video video);
    public Video loadById(Integer id);
    public List<Video> loadAll();

}
