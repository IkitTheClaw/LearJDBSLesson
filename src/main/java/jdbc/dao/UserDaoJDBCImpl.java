package jdbc.dao;

import jdbc.model.User;
import jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() throws SQLException {

    }

    public void createUsersTable() throws ClassNotFoundException {
        try (Connection con = Util.getConnection();
             Statement stmt = con.createStatement()) {
            System.out.println("отработало создание");
            String tableSql = "CREATE TABLE IF NOT EXISTS users"
                    + "(id BIGINT AUTO_INCREMENT NOT NULL,name VARCHAR(30) NULL,"
                    + "lastname VARCHAR(30) NULL,age TINYINT UNSIGNED,"
                    + "PRIMARY KEY (id))";
            stmt.executeUpdate(tableSql);
        } catch (SQLException sqlException) {
            System.out.println("не отработало создание-1");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("не отработало создание-2");
        }
    }


    public void dropUsersTable() throws SQLException, ClassNotFoundException {
        try (Connection con = Util.getConnection(); Statement stmt = con.createStatement()) {
            String dropTableSql = "DROP TABLE IF EXISTS users;";
            stmt.execute(dropTableSql);
            System.out.println("таблица дропнута");
        } catch (SQLException sqlException) {
            System.out.println("Таблица НЕ дропнута");
            sqlException.printStackTrace();
         } catch (ClassNotFoundException classNotFoundException) {
        System.out.println("не дропнута-2");
    }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        try (Connection con = Util.getConnection();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO users (name, lastName, age) VALUES (?,?,?) ")) {
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);

            stmt.executeUpdate();
        }
    }

    /*В тесте всегда значение один
     * в реальной базе значения всегда передаются разные,
     * ведь удалить мы хотим определенного персонажа*/
    public void removeUserById(long id) throws SQLException, ClassNotFoundException {
        try (Connection con = Util.getConnection(); Statement stmt = con.createStatement()) {
            String removeUser = "DELETE FROM users WHERE id = '" + id + "';";
            stmt.executeUpdate(removeUser);
        }
    }

    public List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> allUsers = new ArrayList<>();
        String selectAllUsers = "Select * FROM users";
        try (Connection con = Util.getConnection();
             Statement stmt = con.createStatement();
             ResultSet resultSet = stmt.executeQuery(selectAllUsers)) {

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                allUsers.add(user);
            }
        }
        return allUsers;
    }

    public void cleanUsersTable() throws SQLException, ClassNotFoundException {
        try (Connection con = Util.getConnection(); Statement stmt = con.createStatement()) {
            String dropTable = "DELETE FROM users";
            stmt.executeUpdate(dropTable);
        }
    }
}
