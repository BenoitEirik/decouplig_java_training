package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
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

    public void loopUntilPlayerSucceed(long maxIteration) {
        //TODO implement me
        boolean state = false;
        long t_begin = System.currentTimeMillis(), duration;

        while (state == false) {
            state = nextRound();
            duration = System.currentTimeMillis() - t_begin;

            if (duration >= maxIteration) {
                this.logger.log("Maximum iteration reached");
                break;
            }
            else if (state) {
                SimpleDateFormat formattedDate = new SimpleDateFormat("mm:ss:SSS");
                this.logger.log("Result : " + this.numberToGuess + "\nTime to play: " + formattedDate.format(new Date(duration)));
                break;
            }
        }
    }
}
