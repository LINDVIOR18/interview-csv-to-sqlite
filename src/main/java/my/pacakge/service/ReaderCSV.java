package my.pacakge.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import lombok.extern.slf4j.Slf4j;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Logger;

import static my.pacakge.service.DataToDataBase.dataInsertToDB;


@Slf4j
public class ReaderCSV {

    public static void fileRider(PreparedStatement preparedStatement) throws IOException, CsvValidationException, SQLException {

        log.info("Method fileRider Invoked");

        Reader reader = Files.newBufferedReader(Paths.get(Constants.SAMPLE_CSV_FILE_PATH));
        CSVWriter writer = new CSVWriter(new FileWriter(Constants.LOGS_PATH));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        int recordsReceived = 0;
        int recordsSuccessful = 0;
        int recordsFailed = 0;
        int batchSize = 0;
        final Logger logger = Logger.getLogger("App logs");

        String[] nextRecord;

        while ((nextRecord = csvReader.readNext()) != null) {
            recordsReceived++;
            if (Arrays.asList(nextRecord).contains("")) {
                writer.writeNext(nextRecord);
                recordsFailed++;
            } else {
                dataInsertToDB(preparedStatement, nextRecord);
                recordsSuccessful++;
            }
            if (batchSize++ > 100) {
                preparedStatement.executeBatch();
                batchSize = 0;
            }
        }
        if (batchSize > 0) {
            preparedStatement.executeBatch();
        }
        writer.close();
        reader.close();
        logger.info("a. Numbers of records Received: " + recordsReceived + "\n");
        logger.info("b. Numbers of records Successful: " + recordsSuccessful + "\n");
        logger.info("b. Numbers of records Failed: " + recordsFailed);
    }
}


