package com.flocasts.dao.impl;

import com.flocasts.dao.EventRepository;
import com.flocasts.dao.UserRepository;
import com.flocasts.model.Event;
import com.flocasts.model.EventType;
import com.flocasts.model.User;
import com.flocasts.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by joserubio on 2/14/14.
 */
public class EventRepositoryHibernateImpl implements EventRepository {

    @Override
    public Event save(Event event) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(event);
        event.setId(id);

        session.getTransaction().commit();

        event = HibernateUtil.initializeAndUnproxy(event);

        session.close();

        return event;


    }

    @Override
    public void update(Event event) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.update(event);
        session.getTransaction().commit();

        HibernateUtil.initializeAndUnproxy(event);

        session.close();



    }

    @Override
    public Event loadById(Integer id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Event event = (Event) session.load(Event.class,id);

        session.getTransaction().commit();

        event = HibernateUtil.initializeAndUnproxy(event);

        session.close();

        return event;
    }

    @Override
    public List<Event> loadByUserId(Integer userId, String type) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();


        String hql = "FROM com.flocasts.model.Event as event where event.userId = :user_id";

        if( type != null && EventType.isValidType(type) )
            hql += " and event.type = :event_type";

        Query query = session.createQuery(hql);
        query.setParameter("user_id",userId);

        if( type != null && EventType.isValidType(type) )
            query.setParameter("event_type",type);

        List results = query.list();


        session.getTransaction().commit();

        session.close();

        return results;
    }

    @Override
    public List<Event> loadByVideoId(Integer videoId, String type) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();


        String hql = "FROM com.flocasts.model.Event as event where event.videoId = :video_id";

        if( type != null && EventType.isValidType(type) )
            hql += " and event.type = :event_type";

        Query query = session.createQuery(hql);
        query.setParameter("video_id",videoId);

        if( type != null && EventType.isValidType(type) )
            query.setParameter("event_type",type);

        List results = query.list();


        session.getTransaction().commit();

        session.close();

        return results;

    }

    public List<Event> loadByType(String type,String range) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        //We are still not supporting the range parameter, so ignore it
        //We will return everything for the type

        String hql = "FROM Event as event where event.type = :event_type";

        Query query = session.createQuery(hql);
        query.setParameter("event_type",type);

        List results = query.list();


        session.getTransaction().commit();

        session.close();

        return results;
    }

}
