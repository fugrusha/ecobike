package com.ecobike.service.impl;

import com.ecobike.app.annotation.InjectByType;
import com.ecobike.app.annotation.Singleton;
import com.ecobike.domain.Constants;
import com.ecobike.handler.AddEBikeHandler;
import com.ecobike.handler.AddFoldingBikeHandler;
import com.ecobike.handler.AddSpeedelecHandler;
import com.ecobike.handler.ShowAllHandler;
import com.ecobike.service.PrintService;
import com.ecobike.service.UserInputService;
import com.ecobike.service.WriterService;

import java.nio.file.Path;

@Singleton
public class UserInputServiceImpl implements UserInputService {

    @InjectByType
    private PrintService printService;

    @InjectByType
    private ShowAllHandler showAllHandler;

    @InjectByType
    private AddEBikeHandler addEBikeHandler;

    @InjectByType
    private AddFoldingBikeHandler addFoldingBikeHandler;

    @InjectByType
    private AddSpeedelecHandler addSpeedelecHandler;

    @InjectByType
    private WriterService writerService;

    @Override
    public void handleUserInput(String userInput) {

        String outputFile = System.getProperty("pathToFile",null);
        Path filePath = Path.of(outputFile);

        switch (userInput) {
            case "/showAll":
                showAllHandler.handle(userInput);
                break;
            case "/add 1":
                addFoldingBikeHandler.handle(userInput);
                break;
            case "/add 2":
                addSpeedelecHandler.handle(userInput);
                break;
            case "/add 3":
                addEBikeHandler.handle(userInput);
                break;
            case "/find":
                break;
            case "/help":
                printService.println(Constants.COMMAND_LIST);
                break;
            case "/save":
                writerService.writeToFile(filePath);
                printService.println("File saved!");
                break;
            case "/exit":
                printService.println(Constants.CLOSE_APP);
                System.exit(0);
                break;
            default:
                printService.println("I don't understand you. Please use /help to show all available commands.");
        }
    }
}
