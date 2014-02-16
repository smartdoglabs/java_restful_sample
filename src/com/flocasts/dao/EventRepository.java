package com.flocasts.dao;

import com.flocasts.model.Event;
import com.flocasts.model.User;

import java.util.List;

/**
 * Created by joserubio on 2/14/14.
 */
public interface EventRepository {

    public Event save(Event event);
    public void update(Event event);
    public Event loadById(Integer id);
    public List<Event> loadByUserId(Integer userId, String type);
    public List<Event> loadByVideoId(Integer userId, String type);

    public List<Event> loadByType(String type,String range);

}
