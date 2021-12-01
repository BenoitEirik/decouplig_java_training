package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {
    Logger playerLogger = LoggerFactory.getLogger("player");

    Scanner shell = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        long playerNumber = this.shell.nextInt();
        this.shell.nextLine();    // eat the \n not eaten by nextInt()

        return playerNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            this.playerLogger.log("Smaller");
        }
        else {
            this.playerLogger.log("Greater");
        }
    }
}
