package com.ecobike.domain;

public final class Constants {

    public static final String GREETING_MESSAGE = "~~~Welcome to EcoBike transition system!~~~\n"
            + "version - 0.01\n";
    public static final String FILE_UPLOADED = "Your input file ('%s') was successfully uploaded\n"
            + "There were found: %d records";

    public static final String CLOSE_APP = "~~~Application is closing~~~";

    public static final String INPUT_WAITING = "I am waiting for you command:";

    public static final String COMMAND_LIST = "You can use the following commands:\n"
            + " - /showAll - Show the entire EcoBike catalog\n"
            + " - /add 1 - Add a new folding bike\n"
            + " - /add 2 - Add a new speedelec\n"
            + " - /add 3 - Add a new e-bike\n"
            + " - /find - Find the first item of a particular brand\n"
            + " - /help - List of available commands\n"
            + " - /save - Save bike records to file\n"
            + " - /exit - Close application\n" ;
}
