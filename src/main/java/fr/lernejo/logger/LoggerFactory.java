package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Logger m_logger = new ConsoleLogger();
        return m_logger;
    }
}
