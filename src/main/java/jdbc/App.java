package jdbc;

import jdbc.dao.UserDaoJDBCImpl;
import jdbc.service.UserService;
import jdbc.service.UserServiceImpl;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
        UserDaoJDBCImpl userConnect = new UserDaoJDBCImpl();
        UserService userService = new UserServiceImpl(userConnect);
        userService.saveUser("Антоша", "Мантоша", (byte) 75);
        userService.dropUsersTable();
        userService.dropUsersTable();
        userService.createUsersTable();
    }
}
