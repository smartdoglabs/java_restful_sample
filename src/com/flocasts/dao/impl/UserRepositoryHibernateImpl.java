package com.flocasts.dao.impl;

import com.flocasts.dao.UserRepository;
import com.flocasts.model.User;
import com.flocasts.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by joserubio on 2/14/14.
 */
public class UserRepositoryHibernateImpl implements UserRepository {

    @Override
    public User save(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(user);
        user.setId(id);

        session.getTransaction().commit();

        user = HibernateUtil.initializeAndUnproxy(user);

        session.close();

        return user;


    }

    @Override
    public void update(User user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();

        HibernateUtil.initializeAndUnproxy(user);

        session.close();



    }

    @Override
    public User loadById(Integer id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        User user = (User) session.load(User.class,id);

        session.getTransaction().commit();

        user = HibernateUtil.initializeAndUnproxy(user);

        session.close();

        return user;
    }

}
