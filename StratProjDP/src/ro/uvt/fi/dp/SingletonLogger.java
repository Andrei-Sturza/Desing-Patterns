package ro.uvt.fi.dp;

import java.util.logging.Logger;

public class SingletonLogger {

    private static SingletonLogger instance;
    private Logger logger;

    private SingletonLogger() //Constructor
    {
        logger = Logger.getLogger("UniversalLogger");
    }

    public static SingletonLogger getInstance()
    {
        if(instance == null)
            instance = new SingletonLogger();
        return instance;
    }

    public Logger getLogger()
    {
        return logger;
    }
}
