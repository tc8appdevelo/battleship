package learn.battleship;

import java.util.Scanner;

public class App {
    public static void main(String [] args) {
        Scanner console = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter game size: ");
        int n = console.nextInt();
        Game game = new Game(n);
        console.nextLine();
        System.out.println();
        game.startGame();

        while (!game.isGameOver()) {
            System.out.println("------------------------");
            game.turn();
        }
    }
}
