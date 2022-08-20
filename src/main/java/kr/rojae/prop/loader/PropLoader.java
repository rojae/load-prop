package kr.rojae.prop.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;
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
        if (printConsole) {
            logger.info("----------------------------------------------------------");
            logger.info(String.format("Properties File = %s", listOfFiles.getAbsolutePath()));
            logger.info("----------------------------------------------------------");
        }
    }

    // Properties File's Key:Value Set To System
    default void setEnvOfProperties(InputStream inputStream, boolean printConsole) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);
        Enumeration e = prop.propertyNames();

        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = prop.getProperty(key);
            System.setProperty(key, value);

            if (printConsole)
                logger.info(String.format("%s=%s", key, value));
        }
    }

    // Yaml File's Key:Value Set To System
    default void setEnvOfYaml(InputStream inputStream, boolean printConsole) {
        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(inputStream);
        this.parseYaml(map, null);
    }

    @SuppressWarnings("unchecked")
    default void parseYaml(Map<String, Object> item, String parentKey) {
        Map<String, String> map = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();

        for (String key : item.keySet()) {
            Object value = item.get(key);

            if (value instanceof Map) {
                String parentKeyStr = (parentKey == null ? "" : parentKey + ".");
                Map<String, Object> valueMap = objectMapper.convertValue(value, Map.class);
                parseYaml(valueMap, parentKeyStr + key);
            }
            else {
                String keyStr = (parentKey == null ? "" : parentKey + ".") + key;
                System.setProperty(keyStr, (String) value);
                logger.info(String.format("%s=%s", keyStr, value));
            }
        }
    }

}
