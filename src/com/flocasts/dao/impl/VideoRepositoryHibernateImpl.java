package com.flocasts.dao.impl;


import com.flocasts.dao.VideoRepository;
import com.flocasts.model.Video;
import com.flocasts.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by joserubio on 2/14/14.
 */
public class VideoRepositoryHibernateImpl implements VideoRepository {

    @Override
    public Video save(Video video) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Integer id = (Integer) session.save(video);
        video.setId(id);

        session.getTransaction().commit();

        video = HibernateUtil.initializeAndUnproxy(video);

        session.close();

        return video;


    }

    @Override
    public void update(Video video) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();
        session.update(video);
        session.getTransaction().commit();

        HibernateUtil.initializeAndUnproxy(video);

        session.close();



    }

    @Override
    public Video loadById(Integer id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();

        Video video = (Video) session.load(Video.class,id);

        session.getTransaction().commit();

        video = HibernateUtil.initializeAndUnproxy(video);

        session.close();

        return video;
    }

    @Override
    public List<Video> loadAll() {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();

        session.beginTransaction();


        String hql = "FROM Video";

        Query query = session.createQuery(hql);

        List results = query.list();

        session.getTransaction().commit();

        session.close();

        return results;
    }

}
