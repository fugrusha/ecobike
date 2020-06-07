import com.ecobike.service.Reader;

import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {

        // TODO check without args
        String sysArg = System.getProperty("pathToFile");
        Path filePath = Path.of(sysArg);

        Reader reader = new Reader();
        reader.readFile(filePath);

        System.out.println("~~~Application closed~~~");

    }
}
