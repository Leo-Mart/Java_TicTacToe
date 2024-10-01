import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean keepPlaying = true;
        int roundNumber = 0;

        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        Player p1 = game.createPlayer(sc, 1);
        Player p2 = game.createPlayer(sc, 2);

        while(keepPlaying) {
            boolean running = true;
            Player winner = null;

            Board board = new Board();

            if (roundNumber > 0) {
                System.out.println("The current score is: ");
                System.out.println(p1.getPlayerName() + " has " + p1.getScore());
                System.out.println(p2.getPlayerName() + " has " + p2.getScore());
            }

            game.startGame(p1.getPlayerName());
            Player currentPlayer = p1;

            while (running && winner == null) {
                board.drawBoard();
                game.askForInput(currentPlayer);
                int pos = game.takeUserMarkPlacement(sc);

                if (!board.drawPlayerMark(currentPlayer.getSymbol(), pos)) {
                    continue;
                }

                winner = board.checkWinner(p1, p2);

                if (currentPlayer.getSymbol().equals("X")) {
                    currentPlayer = p2;
                } else {
                    currentPlayer = p1;
                }

                if (winner != null) {
                    board.drawBoard();
                    System.out.println("The winner is player " + winner.getPlayerName() + "!");
                    winner.increaseScore();
                    System.out.println("Do you wish to play again? [Y/N]");
                    String choice = sc.nextLine();

                    if (choice.equalsIgnoreCase("y")) {
                        System.out.println("Restarting game!");
                        roundNumber++;
                    } else {
                        keepPlaying = false;
                        System.out.println("Thanks for playing");
                    }
                    running = false;
                }

                if (board.isBoardFull() && winner == null) {
                    System.out.println("The board is full, it's a draw!");
                    running = false;
                }

            }
        }


    }
}