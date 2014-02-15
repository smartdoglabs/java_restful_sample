package com.flocasts.util;


import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by joserubio on 2/14/14.
 *
 * This class has some utility methods to deal with Hibernate.
 * Remind me not to use Hibernate ever again!! Good thing I'm moving on to node.js and other things, because
 * Lazy loading is a nightmare!!
 *
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     *
     * The purpose of this method is to grab a Hibernate Proxy object and return the real model object.
     * We need to do this because we pass the objects back and forth format he services and they get serialized to
     * JSON. Another option could be to create a DTO object to map values, but I would rather deal with the domain
     * objects. Doing this inside a hibernate session also gets rid of lazy loading issues.
     *
     * @param entity
     * @param <T>
     * @return <T>
     *
     *
     */
    public static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }
}
