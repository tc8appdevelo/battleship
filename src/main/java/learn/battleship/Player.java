package learn.battleship;

import java.util.Scanner;

public class Player {
    public int[] getMove(Scanner scanner) {
        System.out.println("enter a position in \"row col\" format. eg: \"0 0\" or \"1 1\"");
        System.out.print("position: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        int[] move = {row, col};
        return move;
    }
}
