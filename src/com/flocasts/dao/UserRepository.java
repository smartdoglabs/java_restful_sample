package com.flocasts.dao;

import com.flocasts.model.User;

import java.util.List;

/**
 * Created by joserubio on 2/14/14.
 */
public interface UserRepository {

    public User save(User user);
    public void update(User user);
    public User loadById(Integer id);
    public List<User> loadAll();
}
