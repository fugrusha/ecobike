import com.ecobike.EcoBikeApplication;
import com.ecobike.app.Application;
import com.ecobike.app.ApplicationContext;

public class Main {

    public static void main(String[] args) {

        // TODO check without args
        String sysArg = System.getProperty("pathToFile");

        ApplicationContext context = Application.run("com.ecobike");
        EcoBikeApplication ecoBikeApplication = context.getObject(EcoBikeApplication.class);

        ecoBikeApplication.start(sysArg);
    }
}
