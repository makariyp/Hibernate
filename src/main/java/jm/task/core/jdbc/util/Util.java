package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Util {
    private final String USER_NAME = "root";
    private final String PASSWORD = "root";
    private final String URL = "jdbc:mysql://localhost:3306/mysql";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private SessionFactory sessionFactory;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        return connection;
    }
    public SessionFactory getSessionFactory() {
        if (sessionFactory != null) {
            return sessionFactory;
        }
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, DRIVER);
        settings.put(Environment.URL, URL);
        settings.put(Environment.USER, USER_NAME);
        settings.put(Environment.PASS, PASSWORD);
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(User.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
}
