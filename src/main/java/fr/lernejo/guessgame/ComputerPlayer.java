package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player {
    Logger playerLogger = LoggerFactory.getLogger("player");
    Scanner shell = new Scanner(System.in);
    long upper_bound = Long.MAX_VALUE;
    long lower_bound = 0;
    long cursor;


    @Override
    public long askNextGuess() {
        this.cursor = (upper_bound - lower_bound) / 2 + lower_bound;
        return this.cursor;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            this.playerLogger.log("Smaller");
            this.playerLogger.log(Long.toString(this.cursor));
            this.upper_bound = this.cursor;
        }
        else {
            this.playerLogger.log("Greater");
            this.playerLogger.log(Long.toString(this.cursor));
            this.lower_bound = this.cursor;
        }
    }
}
