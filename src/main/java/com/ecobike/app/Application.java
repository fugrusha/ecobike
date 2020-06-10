package com.ecobike.app;

import com.ecobike.app.config.Config;
import com.ecobike.app.config.JavaConfig;

public class Application {

    public static ApplicationContext run(String packageToScan) {
        Config config = new JavaConfig(packageToScan);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory factory = new ObjectFactory(context);
        context.setFactory(factory);

        return context;
    }
}
