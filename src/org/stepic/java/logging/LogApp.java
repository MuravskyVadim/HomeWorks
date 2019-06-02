package org.stepic.java.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LogApp {
    private static final Logger LOGGER_CLASS_A = Logger.getLogger("org.stepic.java.logging.ClassA");
    private static final Logger LOGGER_CLASS_B = Logger.getLogger("org.stepic.java.logging.ClassB");
    private static final Logger LOGGER_FOR_OTHER_CLASSES = Logger.getLogger("org.stepic.java");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        LOGGER_CLASS_A.setLevel(Level.ALL);
        LOGGER_CLASS_B.setLevel(Level.WARNING);

        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());

        LOGGER_FOR_OTHER_CLASSES.addHandler(consoleHandler);
        LOGGER_FOR_OTHER_CLASSES.setUseParentHandlers(false);
    }
}
