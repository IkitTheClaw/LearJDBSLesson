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
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.createUsersTable();
        userService.saveUser("vova","ivanov", (byte) 99);
        userService.saveUser("vova","ivanov", (byte) 99);
        userService.saveUser("vova","ivanov", (byte) 99);
        userService.removeUserById(1);
        userService.removeUserById(0);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
    }
}
