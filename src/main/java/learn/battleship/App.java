package learn.battleship;

import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter game size: ");
        int n = console.nextInt();
        Battleship battleship = new Battleship(n);
        console.nextLine();
        System.out.println();
        battleship.startGame();

        while (!battleship.isGameOver()) {
            System.out.println("------------------------");
            battleship.turn();
        }
    }
}
