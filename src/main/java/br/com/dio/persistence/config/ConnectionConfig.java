package br.com.dio.persistence.config;

import static lombok.AccessLevel.PRIVATE;
import lombok.AllArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@AllArgsConstructor(access = PRIVATE)
public class ConnectionConfig {
    public static Connection getConnection() throws SQLException {
        var url = "jdbc:mysql://localhost/board";
        var user = "board";
        var password = "12345678";
        var connection = DriverManager.getConnection(url,user,password);
        connection.setAutoCommit(false);
        return connection;
    }
}
