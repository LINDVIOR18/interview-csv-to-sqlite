package my.pacakge;

import org.apache.log4j.BasicConfigurator;
import my.pacakge.service.DataBaseConnection;

public class InterviewTaskApplication {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        DataBaseConnection.connect();
    }
}
