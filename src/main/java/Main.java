import com.ecobike.Application;

public class Main {

    public static void main(String[] args) {

        // TODO check without args
        String sysArg = System.getProperty("pathToFile");

        Application application = new Application();
        application.start(sysArg);
    }
}
