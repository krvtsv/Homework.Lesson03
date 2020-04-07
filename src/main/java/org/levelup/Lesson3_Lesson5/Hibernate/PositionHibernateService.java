package org.levelup.Lesson3_Lesson5.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.levelup.Lesson3_Lesson5.domain.Position;
import org.levelup.Lesson3_Lesson5.domain.PositionService;


import java.util.Collection;
import java.util.List;

public class PositionHibernateService implements PositionService {
    private final SessionFactory factory;

    public PositionHibernateService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Position createPosition(String name){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Position position = new Position();//condition --> transient
        position.setName(name);
        session.persist(position);//condition --> managed/persistent
        transaction.commit();//condition --> detached
        session.close();
        return position;
    }

    @Override
    public void deletePositionById(int id){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Position position = session.get(Position.class, id);
        session.delete(position);
        transaction.commit();
        session.close();
    }



    @Override
    public void deletePositionByName(String name){
        Position position = findPositionByName(name);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(position);
        transaction.commit();
        session.close();
    }

    @Override
    public Collection<Position> findAllPositionWhichNameLike(String name){
        Session session = factory.openSession();
        Query query = session.createQuery("from Position where name like :name");
        query.setParameter("name",name);
        List<Position> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Position findPositionById(int id){
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Position position = session.get(Position.class, id);
        transaction.commit();
        session.close();
        return position;
    }

    @Override
    public Collection<Position> findAllPositions(){
        Session session = factory.openSession();
        Query query = session.createQuery("from Position");
        List<Position> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Position findPositionByName(String name){
        Session session = factory.openSession();
        Query query = session.createQuery("from Position where name=:name");
        query.setParameter("name",name);
        Position position = (Position)query.uniqueResult();
        session.close();
        return position;
    }
}
