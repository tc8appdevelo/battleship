package learn.battleship;

import java.util.Scanner;

public class Game {
    public Scanner console = new Scanner(System.in);
    private Board board;
    private Player player;
    private int remainingMisses;

    public Game(int n) {
        this.board = new Board(n);
        this.player = new Player();
        this.remainingMisses = board.getSize()/2;
    }

    public Board getBoard() {
        return board;
    }

    public void startGame() {
        board.placeRandomShips();
        System.out.println("There are " + board.numShips() + " hidden ships on the board.");
        board.printGameBoard();
    }

    public boolean lose() {
        if (remainingMisses <= 0) {
            System.out.println("You lose.");
            return true;
        } else {
            return false;
        }
    }

    public boolean win() {
        if (board.numShips() == 0) {
            System.out.println("You win!");
            return true;
        } else {
            return false;
        }
    }

    public boolean isGameOver() {
        return lose() || win();
    }

    public void turn() {
        int[] pos = player.getMove(console);
        if (!board.attack(pos[0], pos[1])) {
            remainingMisses -= 1;
        }
        board.printGameBoard();
        System.out.println(remainingMisses + " remaining misses");
    }
}
