import java.util.ArrayList;

public class Board {
    private ArrayList<String> board = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 9; i++) {
            board.add(" ");
        }
    }

    public void drawBoard() {
        System.out.println("****************************");
        System.out.println(board.get(0) + " | " + board.get(1) + " | " + board.get(2));
        System.out.println("-----+---+-----");
        System.out.println(board.get(3) + " | " + board.get(4) + " | " + board.get(5));
        System.out.println("-----+---+-----");
        System.out.println(board.get(6) + " | " + board.get(7) + " | " + board.get(8));
        System.out.println("****************************");
    }

    public boolean drawPlayerMark(String mark, int pos) {
        if (isPosFree(pos) && pos >= 1 && pos <= 9) {
            board.set(pos - 1, mark);
            return true;
        }
        System.out.println("That spot is already taken, try another one!");
        return false;
    }

    public boolean isPosFree(int pos) {
        return board.get(pos - 1).equals(" ");
    }

    public boolean isBoardFull() {
        int count = 0;

        for (String s : board) {
            if (s.contains("X") || s.contains("O")) {
                count++;
            }
        }

        return count == 9;
    }

    public Player checkWinner(Player p1, Player p2) {
        Player winningPlayer = null;

        for (int i = 0; i < 8; i++) {
            String line = switch (i) {
                case 0 -> board.get(0) + board.get(1) + board.get(2);
                case 1 -> board.get(3) + board.get(4) + board.get(5);
                case 2 -> board.get(6) + board.get(7) + board.get(8);
                case 3 -> board.get(0) + board.get(3) + board.get(6);
                case 4 -> board.get(1) + board.get(4) + board.get(7);
                case 5 -> board.get(2) + board.get(5) + board.get(8);
                case 6 -> board.get(0) + board.get(4) + board.get(8);
                case 7 -> board.get(2) + board.get(4) + board.get(6);
                default -> line = null;
            };

            // this will work in this case since I've hardcoded p1 to always be X and p2 to always be O.
            // Not the most elegant but works for now.
            if (line.equals("XXX")) {
                winningPlayer = p1;
            } else if (line.equals("OOO")) {
                winningPlayer = p2;
            }
        }
        return winningPlayer;
    }

}
