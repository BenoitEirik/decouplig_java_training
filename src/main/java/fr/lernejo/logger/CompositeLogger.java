package fr.lernejo.logger;

public class CompositeLogger implements Logger {
    Logger logger1, logger2;

    CompositeLogger(Logger logger1, Logger logger2) {
        this.logger1 = logger1;
        this.logger2 = logger2;
    }

    @Override
    public void log(String message) {
        this.logger1.log(message);
        this.logger2.log(message);
    }
}
