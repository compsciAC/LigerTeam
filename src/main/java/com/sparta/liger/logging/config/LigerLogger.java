package com.sparta.liger.logging.config;

import com.sparta.liger.App;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LigerLogger {
    public static final Logger logger = Logger.getLogger(App.class.getName());

    public static void ligerLogger() {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        consoleHandler.setFormatter(new CustomFormatter());
        logger.setUseParentHandlers(false);
        //logger.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.addHandler(FileHandlerConfig.getFileHandler()); }
}

