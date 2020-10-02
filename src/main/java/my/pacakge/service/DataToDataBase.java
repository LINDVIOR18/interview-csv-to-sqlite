package my.pacakge.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataToDataBase {

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
