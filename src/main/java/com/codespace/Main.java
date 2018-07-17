package com.codespace;

import com.codespace.myLibraryWorkflow.Controller;
import org.apache.log4j.Logger;



public class Main {
    static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("App started.");
        new Controller().run();
    }
}
