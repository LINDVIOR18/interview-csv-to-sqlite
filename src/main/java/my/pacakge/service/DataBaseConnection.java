package my.pacakge.service;

import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static my.pacakge.service.Constants.JDBC_URL;
import static my.pacakge.service.Constants.SQL_INSERT;

@Slf4j
public class DataBaseConnection {

    public static void connect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL);
            preparedStatement = connection.prepareStatement(SQL_INSERT);

            log.info("Database connection success");

        } catch (SQLException e) {
            log.info("SQL connection on Failed at class method my.pacakge.service.DataBaseConnection.connect()");
        }
        try {
            ReaderCSV.fileRider(preparedStatement);
        } catch (IOException | CsvValidationException | SQLException e) {
            System.err.println(e.getMessage());
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
