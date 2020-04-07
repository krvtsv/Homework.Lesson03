package org.levelup.Lesson3_Lesson5.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.levelup.Lesson3_Lesson5.domain.User;
import org.levelup.Lesson3_Lesson5.domain.UserService;
import java.util.Collection;
import java.util.List;

public class UserHibernateService implements UserService {
    private final SessionFactory factory;

    public UserHibernateService(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public User createUser( String passport, String name, String lastName)  {
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            User user = new User();//condition --> transient
            user.setName(name);
            user.setLastName(lastName);
            user.setPassport(passport);
            session.persist(user);//condition -->managed/persistent
            transaction.commit();//condition -->detached
            session.close();
            return user;
        }
    @Override
    public User findByPassport(String passport)  {
            Session session = factory.openSession();
            User user = session.byNaturalId(User.class).using("passport", passport).load();
            session.close();
            return user;
        }
    @Override
    public Collection<User> findByNameAndLastName(String name, String lastName)  {
        Session session = factory.openSession();
        Query query = session.createQuery("from User where name=:name and lastName=:lastName");
        query.setParameter("name",name);
        query.setParameter("lastName",lastName);
        List <User> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Collection<User> findByLastName(String lastName) {
        Session session = factory.openSession();
        Query query = session.createQuery("from User where lastName=:lastName");
        query.setParameter("lastName",lastName);
        List <User> list = query.list();
        session.close();
        return list;
    }

    @Override
    public void deleteUserByPassport(String passport) {
        User user = findByPassport(passport);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }
    @Override
    public User updateUser(String passport, String name, String lastName) {
            User user = findByPassport(passport);
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();
            user.setName(name);
            user.setLastName(lastName);
            User mergedUser = (User) session.merge(user);
            transaction.commit();
            session.close();
            return mergedUser;
    }
}
