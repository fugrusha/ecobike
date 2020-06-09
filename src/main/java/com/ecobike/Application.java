package com.ecobike;

import com.ecobike.app.Constants;
import com.ecobike.app.DataCache;
import com.ecobike.app.ObjectFactory;
import com.ecobike.service.ReaderService;
import com.ecobike.service.UserInputService;

import java.nio.file.Path;
import java.util.Scanner;

public class Application {
    private ReaderService readerService = ObjectFactory.getInstance().createObject(ReaderService.class);
    private UserInputService uis = ObjectFactory.getInstance().createObject(UserInputService.class);
    private DataCache dataCache = ObjectFactory.getInstance().createObject(DataCache.class);

    public void start(String sysArg) {
        print(Constants.GREETING_MESSAGE);

        Path filePath = Path.of(sysArg);
        readerService.readFile(filePath);

        print(String.format(Constants.FILE_UPLOADED, sysArg, dataCache.size()));
        print(Constants.COMMAND_LIST);

        System.out.println(dataCache + " from application");

        Scanner in = new Scanner(System.in);
        print("I am waiting for you command:");

        String userInput = in.nextLine();

        while (true) {
            uis.handleUserInput(userInput);
            userInput = in.nextLine();
        }
    }

    public void print(String message) {
        System.out.println(message);
    }
}
