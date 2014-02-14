package com.flocasts.dao;

import com.flocasts.model.User;

/**
 * Created by joserubio on 2/14/14.
 */
public interface UserRepository {

    public User save(User user);
    public User loadById(Integer id);
}
