package com.ecobike.service.impl;

import com.ecobike.app.Constants;
import com.ecobike.app.ObjectFactory;
import com.ecobike.handler.ShowAllHandler;
import com.ecobike.service.UserInputService;

public class UserInputServiceImpl implements UserInputService {

    private ShowAllHandler showAllHandler = ObjectFactory.getInstance().createObject(ShowAllHandler.class);

    @Override
    public void handleUserInput(String userInput) {

        switch (userInput) {
            case "/showAll":
                showAllHandler.handle(userInput);
                break;
            case "/show 1":
                break;
            case "/show 2":
                break;
            case "/show 3":
                break;
            case "/add":
                break;
            case "/find":
                break;
            case "/help":
                print(Constants.COMMAND_LIST);
                break;
            case "/save":
                print("File saved!");
                break;
            case "/exit":
                print(Constants.CLOSE_APP);
                System.exit(0);
                break;
            default:
                print("I don't understand you. Please use /help to show all available commands.");
        }
    }

    public void print(String message) {
        System.out.println(message);
    }
}
