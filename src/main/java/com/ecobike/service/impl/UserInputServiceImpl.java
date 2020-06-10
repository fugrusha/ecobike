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

    @Override
    public void handleUserInput(String userInput) {

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
