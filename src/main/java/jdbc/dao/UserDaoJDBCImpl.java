package jdbc.dao;

import jdbc.model.User;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
    }

    public void dropUsersTable() {
    }

    public void saveUser(String name, String lastName, byte age) {
    }

    /*В тесте всегда значение один
     * в реальной базе значения всегда передаются разные,
     * ведь удалить мы хотим определенного персонажа*/
    public void removeUserById(long id) {
    }

    public List<User> getAllUsers() {
        return List.of();
    }

    public void cleanUsersTable() {
    }
}
