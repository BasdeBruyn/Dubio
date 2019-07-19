package daos;

import exceptions.OpenDatabaseConnectionException;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Bas de Bruyn
 */
class ConnectionFactory {
    private static final String URL = "jdbc:driver://host/db";
    private static final String USER = "user";
    private static final String PASS = "password";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException exception) {
            throw new OpenDatabaseConnectionException();
        }
    }
}
