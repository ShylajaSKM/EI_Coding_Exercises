package com.smart_home_system.core;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtility {
    private static final Logger logger = Logger.getLogger("SmartHomeLogger");

    static {
        ConsoleHandler handler = new ConsoleHandler();
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }

    public static void info(String msg) {
        logger.log(Level.INFO, msg);
    }

    public static void warning(String msg) {
        logger.log(Level.WARNING, msg);
    }

    public static void severe(String msg) {
        logger.log(Level.SEVERE, msg);
    }
}
