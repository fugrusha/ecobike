package com.ecobike;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.cache.DataCache;
import com.ecobike.domain.Bicycle;
import com.ecobike.domain.Constants;
import com.ecobike.service.PrintService;
import com.ecobike.service.ReaderService;
import com.ecobike.service.UserInputService;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.UUID;

public class EcoBikeApplication {

    @InjectByType
    private ReaderService readerService;

    @InjectByType
    private UserInputService uis;

    @InjectByType
    private PrintService printService;

    @InjectByType
    private DataCache<UUID, Bicycle> dataCache;

    public void start(String sysArg) {
        printService.println(Constants.GREETING_MESSAGE);

        Path filePath = Path.of(sysArg);
        readerService.readFile(filePath);

        printService.printf(String.format(Constants.FILE_UPLOADED, sysArg, dataCache.size()));
        printService.println(Constants.COMMAND_LIST);

        Scanner in = new Scanner(System.in);
        printService.println(Constants.INPUT_WAITING);

        String userInput = in.nextLine();

        while (true) {
            uis.handleUserInput(userInput);

            printService.println(Constants.INPUT_WAITING);
            userInput = in.nextLine();
        }
    }
}
