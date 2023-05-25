package jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdbc.dao.UserDaoHibernateImpl;
import jdbc.dao.UserDaoJDBCImpl;
import jdbc.service.UserService;
import jdbc.service.UserServiceImpl;
import jdbc.util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.logging.Level;

import static jdbc.util.HibernateUtil.getSessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();

        UserService userService = new UserServiceImpl(userDaoHibernate);

        System.out.println(userService.getAllUsers());


        //----------------------MANUAL WORK WITH DATABASES--------------------------
//        UserDaoJDBCImpl userConnect = new UserDaoJDBCImpl();
//        UserService userService = new UserServiceImpl(userConnect);
//        userService.dropUsersTable();
//        userService.createUsersTable();
//        userService.createUsersTable();
//        userService.saveUser("vova","ivanov", (byte) 99);
//        userService.saveUser("vova","ivanov", (byte) 99);
//        userService.saveUser("vova","ivanov", (byte) 99);
//        userService.removeUserById(1);
//        userService.removeUserById(0);
//        System.out.println(userService.getAllUsers());
//        userService.cleanUsersTable();
    }

}
