package jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdbc.dao.UserDao;
import jdbc.dao.UserDaoHibernateImpl;
import jdbc.service.UserService;
import jdbc.service.UserServiceImpl;
import org.hibernate.Session;

import java.sql.SQLException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDao userDao = new UserDaoHibernateImpl(entityManager);

        userDao.createUsersTable();
        userDao.saveUser("Jack","Horner",(byte) 68);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        System.out.println(userDao.getAllUsers());
        userDao.dropUsersTable();

//





    }

}
