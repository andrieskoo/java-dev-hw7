package org.example;

import org.example.config.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class H2Database {

//    private String URL = "jdbc:h2:~/test";
//    private String user = "sa";
//    private String password;
//
    private static H2Database INSTANCE;

    private final Connection connection;

    private H2Database() {

        try {
            connection = DriverManager.getConnection(PropertyReader.getH2ConnectionFromProperties());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static H2Database getINSTANCE() {
        return Objects.requireNonNullElseGet(INSTANCE, H2Database::new);
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
