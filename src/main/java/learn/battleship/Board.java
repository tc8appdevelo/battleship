package learn.battleship;

import java.util.Random;

public class Board {
    private char[][] grid;
    private int size;
    private final Random random = new Random();

    public static void printGrid(char[][] arr2d) {
        for(char[] chars : arr2d) {
            for (char c : chars) {
                System.out.print(" " + c);
            }
            System.out.println();
        }
    }

    public Board(int n) {
        this.grid = new char[n][n];
        this.size = n * n;
        for (char[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                row[i] = 'N';
            }
        }
//        placeRandomShips();
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getSize() {
        return size;
    }

    public char getPosition(int row, int col) {
        return grid[row][col];
    }

    public void setPosition(int row, int col, char value) {
        grid[row][col] = value;
    }


    public int numShips() {
        int numShips = 0;
        for (char[] row : grid) {
            for (char c : row) {
                if (c == 'S') {
                    numShips++;
                }
            }
        }
        return numShips;
    }

    // had a check that this used the setPosition method
    // not sure if necessary, but need to figure out
    // how to write that test anyway later
    public boolean attack(int row, int col) {
        if (grid[row][col] == 'S') {
            grid[row][col] = 'H';
            System.out.println("You sunk my battleship!");
            return true;
        } else {
            grid[row][col] = 'X';
            return false;
        }
    }

    public void placeRandomShips() {
        int maxShips = (int) (0.25 * getSize());

        while (numShips() < maxShips) {
            int row = random.nextInt(grid.length);
            int col = random.nextInt(grid.length);
            setPosition(row, col, 'S');
        }
    }

    public char[][] hiddenShipsGrid() {
        char[][] hidden = new char[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 'S') {
                    hidden[i][j] = 'N';
                } else {
                    hidden[i][j] = grid[i][j];
                }
            }
        }
        return hidden;
    }

    public void cheat() {
        Board.printGrid(getGrid());
    }

    public void printGameBoard() {
        Board.printGrid(hiddenShipsGrid());
    }


}
