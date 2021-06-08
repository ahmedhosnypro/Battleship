package battleship;

import java.io.FileNotFoundException;
import static battleship.Game.startGame;
import static battleship.ShipPosition.takePosition;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GameField gameField = new GameField();
        takePosition(gameField);
        gameField.printField();
        startGame(gameField);
    }
}
