package my.pacakge.service;

import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class DataBaseConnection {

    public static void connect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String url = "jdbc:sqlite:src/main/resources/database/interviewDB.db";
            connection = DriverManager.getConnection(url);
            preparedStatement = connection.prepareStatement(Constants.SQL_INSERT);

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

    public static void dataInsertToDB(PreparedStatement preparedStatement, String[] nextRecord) throws SQLException {

        preparedStatement.setString(1, nextRecord[0]);
        preparedStatement.setString(2, nextRecord[1]);
        preparedStatement.setString(3, nextRecord[2]);
        preparedStatement.setString(4, nextRecord[3]);
        preparedStatement.setString(5, nextRecord[4]);
        preparedStatement.setString(6, nextRecord[5]);
        preparedStatement.setString(7, nextRecord[6]);
        preparedStatement.setString(8, nextRecord[7]);
        preparedStatement.setString(9, nextRecord[8]);
        preparedStatement.setString(10, nextRecord[9]);

        preparedStatement.addBatch();
    }
}
