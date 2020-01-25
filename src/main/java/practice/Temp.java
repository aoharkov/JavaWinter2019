package practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Temp {
    private static Logger logger = LogManager.getLogger(Temp.class);

    public static void main(String[] args) {
        System.out.println("Start");
        logger.info("this info");
        logger.error("this error");
        System.out.println("end");
    }
}
