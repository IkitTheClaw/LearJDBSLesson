package jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static String DB_HOST  = "localhost";
    private static String DB_USERNAME = "root";
    private static String DB_PASSWORD = "You_Shel1_NotPass";
    private static String DB_NAME = "myDb";
    private static String DB_PORT = ":3306/";
    private static String URL = "jdbc:mysql://"    //jdbc:postgresql://<host>:<port>/<database_name>?<connection_parameters>
            + DB_HOST
            + DB_PORT
            + DB_NAME;

    /**
     * Получить соединение с базой данных PostgreSQL с использованием заданных параметров подключения.
     * @param connectionURL URL для подключения к базе данных PostgreSQL
     * @param username имя пользователя базы данных PostgreSQL
     * @param password пароль пользователя базы данных PostgreSQL
     * @return соединение с базой данных PostgreSQL
     * @throws SQLException если не удалось установить соединение с базой данных
     */
    public static Connection getConnection(String connectionURL,
                                           String username,
                                           String password)
            throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =  DriverManager.getConnection(connectionURL,
                username, password);
        return connection;
    }

    /**
     * Получить соединение с базой данных PostgreSQL с использованием параметров подключения,
     * заданных внутри класса.
     * @return соединение с базой данных PostgreSQL
     * @throws SQLException если не удалось установить соединение с базой данных
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getConnection(URL, DB_USERNAME, DB_PASSWORD);
    }
}
