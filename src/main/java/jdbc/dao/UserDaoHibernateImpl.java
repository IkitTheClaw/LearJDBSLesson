package jdbc.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jdbc.entity.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void createUsersTable() {
        String sql = "CREATE TABLE users " +
                "(id BIGINT," +
                "name VARCHAR(50)," +
                "lastname VARCHAR(50)," +
                "age TINYINT," +
                " PRIMARY KEY(id));";

        Query query = entityManager.createNativeQuery(sql);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE users";

        Query query = entityManager.createNativeQuery(sql);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        entityManager.getTransaction().begin();
        User user = new User();
        user.setName(name);
        user.setLastname(lastName);
        user.setAge(age);

        entityManager.persist(user);
        entityManager.getTransaction().commit();


    }

    @Override
    public void removeUserById(long id) {
        String sql = "delete User WHERE id =" + id;
        Query query = entityManager.createQuery(sql);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;
        String sql = "FROM User";

        Query query = entityManager.createQuery(sql);
        entityManager.getTransaction().begin();
        userList = query.getResultList();
        entityManager.getTransaction().commit();
        return userList;
    }


    @Override
    public void cleanUsersTable() {
        String sql = "delete  User ";

        Query query = entityManager.createQuery(sql);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }
}





















