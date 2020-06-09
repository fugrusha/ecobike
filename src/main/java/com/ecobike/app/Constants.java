package com.ecobike.app;

public final class Constants {

    public static final String GREETING_MESSAGE = "~~~Welcome to EcoBike transition system!~~~\n"
            + "version - 0.01\n";
    public static final String FILE_UPLOADED = "Your input file ('%s') was successfully uploaded\n"
            + "There were found: %d records";

    public static final String CLOSE_APP = "~~~Application is closing~~~";

    public static final String COMMAND_LIST = "You can use the following commands:\n"
            + " - /showAll - Show the entire EcoBike catalog\n"
            + " - /show 1 - Show list of Folding Bike records\n"
            + " - /show 2 - Show list of E-bike records\n"
            + " - /show 3 - Show list of Speedelec records\n"
            + " - /add - add new bike's record to list\n"
            + " - /find - search bikes by brand\n"
            + " - /help - list of available commands\n"
            + " - /save - save bike records to file\n"
            + " - /exit - close application\n" ;
}
