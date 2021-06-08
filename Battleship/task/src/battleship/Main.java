package battleship;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static battleship.Game.startGame;
import static battleship.ShipPosition.takePosition;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        GameField fstPlayerField = new GameField();
        takePosition(fstPlayerField);


        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();
        System.out.println("Player 2, place your ships to the game field");
        System.out.println();
        GameField sndPlayerField = new GameField();
        takePosition(sndPlayerField);

        startGame(fstPlayerField, sndPlayerField);
    }
}
