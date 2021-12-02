package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        //Logger m_logger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger("gameguess.log");
        ContextualLogger contextualFileLogger = new ContextualLogger(name, fileLogger);

        ConsoleLogger consoleLogger = new ConsoleLogger();
        ContextualLogger contextualConsoleLogger = new ContextualLogger(name,consoleLogger);

        CompositeLogger cpLogger = new CompositeLogger(contextualFileLogger, contextualConsoleLogger);
        return cpLogger;
    }
}
