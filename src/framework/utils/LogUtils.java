package framework.utils;

import org.apache.log4j.Logger;

public class LogUtils {
    private static final Logger log = Logger.getLogger(LogUtils.class);

    public static void info(String message) {
        log.info(message);
    }

    public static void error(String message) {
        log.error(message);
    }

}
