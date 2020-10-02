import org.apache.log4j.BasicConfigurator;
import service.DataBaseConnection;

public class InterviewTaskApplication {

    public static void main(String[] args) {
        BasicConfigurator.configure();

        DataBaseConnection.connect();
    }
}

