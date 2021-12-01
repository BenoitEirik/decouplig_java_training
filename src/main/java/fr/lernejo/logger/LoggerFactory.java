package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        //Logger m_logger = new ConsoleLogger();
        FileLogger f_Logger = new FileLogger("gameguess.log");
        ContextualLogger cLogger = new ContextualLogger(name, f_Logger);
        return cLogger;
    }
}
