package my.pacakge.service;

public class Constants {

    public static final String JDBC_URL = "jdbc:sqlite:src/main/resources/database/interviewDB.db";
    public static final String SAMPLE_CSV_FILE_PATH = "src/main/resources/csv/Interview-task-data-osh .csv";
    public static final String SQL_INSERT = "INSERT INTO main.user_table(A, B, C, D, E, F, G, H, I, J) VALUES(?,?,?,?,?,?,?,?,?,?)";
    public static final String LOGS_PATH = "src/main/resources/csv/logs.log";
}
