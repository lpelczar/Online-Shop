package frompythontojava.onlineshop.logs;

import java.io.IOException;
import java.util.logging.*;

public class ProcessLogger {

    public static void log(String message) {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            fh = new FileHandler("src/frompythontojava/onlineshop/logs/processes.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);
            logger.log(Level.INFO ,message);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
