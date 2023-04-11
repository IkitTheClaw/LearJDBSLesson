package jdbc;

import jdbc.dao.UserDaoJDBCImpl;

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
        userConnect.saveUser("Антоша", "Мантоша", (byte) 75);
        userConnect.dropUsersTable();
        userConnect.dropUsersTable();
        userConnect.createUsersTable();
    }
}
