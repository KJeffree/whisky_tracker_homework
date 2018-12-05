package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Distillery> findAllDistilleriesFromRegion(String region){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.add(Restrictions.eq("region", region));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

//    @Transactional
//    public List<Whisky> findAllWhiskyFromDistilleryOfAge(String name, int age){
//        List<Whisky> results = null;
//
//        Session session = entityManager.unwrap(Session.class);
//
//        try {
//            Criteria cr = session.createCriteria(Distillery.class);
//            cr.createAlias("whiskeys", "whisky");
//            cr.add(Restrictions.eq("name", name));
//            cr.add(Restrictions.eq("whisky.age", age));
//            results = cr.list();
//        } catch (HibernateException ex) {
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        return results;
//    }

    @Transactional
    public List<Distillery> findAllDistilleriesWithWhiskeyOfAge(int age){
        List<Distillery> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whisky");
            cr.add(Restrictions.eq("whisky.age", age));
            results = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

}
