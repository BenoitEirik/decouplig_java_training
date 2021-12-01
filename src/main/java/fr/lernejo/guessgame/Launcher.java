package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        long maxiTeration;

        if (args.length == 1) {
            if (!args[0].equals("-interactive")) {
                System.out.println("Arguments error");
                return;
            }

            HumanPlayer player = new HumanPlayer();
            Simulation game = new Simulation(player);
            maxiTeration = Long.MAX_VALUE;

            // generate random number
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

            game.initialize(randomNumber);
            game.loopUntilPlayerSucceed(maxiTeration);
        }
        else if (args.length == 2) {
            if (!args[0].equals("-auto")) {
                System.out.println("Arguments error");
                return;
            }

            ComputerPlayer cPlayer = new ComputerPlayer();
            Simulation cGame = new Simulation(cPlayer);
            maxiTeration = 1000;

            long numberToGuess;
            try {
                numberToGuess = Long.parseLong(args[1]);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: argument 2 is not a integer");
                return;
            }
            cGame.initialize(numberToGuess);
            cGame.loopUntilPlayerSucceed(maxiTeration);
        }
        else {
            System.out.println("Usage: \n\t-interactive\t\tplay the game\n\t-auto <integer>\t\tcomputer play the game with <integer> to find");
        }
    }
}
