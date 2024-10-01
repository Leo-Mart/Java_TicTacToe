import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public void startGame(String playerName) {
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println("Player " + playerName + " goes first, then you take turns");

    }

    public void askForInput(Player currentPlayer) {
        System.out.println("Player " + currentPlayer.getPlayerName() + " it is your turn");
        System.out.println("Enter a choice between 1--9, to place your marker");
    }

    public Player createPlayer(Scanner sc, int playerNumber) {
        System.out.printf("Player %d enter your name: \n", playerNumber);
        String name = sc.nextLine();
        Player newPlayer = new Player(name, "X");
        if (playerNumber == 1) {
            System.out.printf("Player %s your symbol is X\n", name);
        } else {
            System.out.printf("Player %s your symbol is O\n", name);
            newPlayer.setSymbol("O");
        }


        return newPlayer;

    }

    public int takeUserMarkPlacement(Scanner sc) {
        int numInput = 0;
        try {
            numInput = sc.nextInt();
            sc.nextLine(); // consume the end of line token otherwise scanner will just skip taking input next time.
            if (!(numInput >= 1 && numInput <= 9)) {
                System.out.println("Please enter a number between 1 and 9");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number between 1 and 9");
        }

        return numInput;
    }
}
