package practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Temp {
    private static final Logger LOGGER = LogManager.getLogger(Temp.class);

    public static void main(String[] args) {
        System.out.println("Start");
        LOGGER.info("this info");
        LOGGER.error("this error");
        System.out.println("end");
    }
}
