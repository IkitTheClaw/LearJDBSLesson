package jdbc.dao;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jdbc.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import static jdbc.util.HibernateUtil.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    private SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        sessionFactory = getSessionFactory();
    }

    @Override
    public void createUsersTable() {
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        String tableSql =  "create TABLE users" +
//                 "(id BIGINT NOT NULL AUTO_INCREMENT,name VARCHAR(30) NULL,"+
//                 "lastname VARCHAR(30) NULL,age TINYINT UNSIGNED,"+
//                 "PRIMARY KEY (id))";
//
//        Query query = session.createQuery(tableSql);
//        query.executeUpdate();
//
//        transaction.commit();
//        session.close();
  }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(name);
        session.update(lastName);
        session.update(age);

        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(id);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();


        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(User.class);
        Root<User> root = cq.from(User.class);
        cq.select(root);


        Query query = session.createQuery(cq);
        List<User> userList = query.getResultList();
        session.close();

        return userList;
    }

    @Override
    public void cleanUsersTable() {
//        Session session = getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//
//        String sql = "delete table users";
//
//        Query query = session.createQuery(sql);
//
//        transaction.commit();
//        session.close();
//
    }
}





















