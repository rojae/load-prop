package kr.rojae.prop.loader;

import java.io.File;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.*;

public interface PropLoader {
    Logger logger = Logger.getLogger(PropLoader.class.getName());

    // properties run method
    void run();

    // properties files loader method
    void loader(File folder);

    // logger init
    default void init() {
        this.logger.setUseParentHandlers(false);

        // add new log handler
        Handler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });
        this.logger.addHandler(handler);
    }

    // File load comment
    default void comment(File listOfFiles, boolean printConsole) {
        if(printConsole) {
            logger.info("----------------------------------------------------------");
            logger.info(String.format("Properties File = %s", listOfFiles.getAbsolutePath()));
            logger.info("----------------------------------------------------------");
        }
    }

    // For < Java 8
    // Key Value load comment
    default void setEnv(Properties prop, boolean printConsole) {
        Enumeration e = prop.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            System.setProperty(key, value);

            if(printConsole)
                logger.info(String.format("%s=%s", key, value));
        }
    }

}
