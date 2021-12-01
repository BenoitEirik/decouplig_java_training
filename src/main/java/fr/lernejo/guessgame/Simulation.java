package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final HumanPlayer player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = (HumanPlayer) player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long playerNumber = this.player.askNextGuess();

        if (playerNumber == this.numberToGuess) {
            return  true;
        }
        else if (playerNumber > this.numberToGuess) {
            this.player.respond(false);
            return false;
        }
        else if (playerNumber < this.numberToGuess) {
            this.player.respond(true);
            return false;
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        boolean state = false;

        while (state == false) {
            state = nextRound();

            if (state) {
                break;
            }
        }
    }
}
