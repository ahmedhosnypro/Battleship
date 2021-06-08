package battleship;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class GameField {
    private String[][] gameField = new String[11][11];
    private String[][] hiddenField = new String[11][11];
    private String[][] visualField = new String[11][11];
    private int[][] AircraftCarrier;
    private int[][] Battleship;
    private int[][] Submarine;
    private int[][] Cruiser;
    private int[][] Destroyer;

    {
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (i == 0 && j == 0) {
                    gameField[0][0] = " ";
                } else if (i == 0) {
                    gameField[0][j] = String.valueOf(j);
                } else if (j == 0) {
                    gameField[i][0] = String.valueOf((char) (i + 64));
                } else {
                    gameField[i][j] = "~";
                }
            }
        }

        for (int i = 0; i < hiddenField.length; i++) {
            for (int j = 0; j < hiddenField.length; j++) {
                if (i == 0 && j == 0) {
                    hiddenField[0][0] = " ";
                } else if (i == 0) {
                    hiddenField[0][j] = String.valueOf(j);
                } else if (j == 0) {
                    hiddenField[i][0] = String.valueOf((char) (i + 64));
                } else {
                    hiddenField[i][j] = "~";
                }
            }
        }

        for (int i = 0; i < visualField.length; i++) {
            for (int j = 0; j < visualField.length; j++) {
                if (i == 0 && j == 0) {
                    visualField[0][0] = " ";
                } else if (i == 0) {
                    visualField[0][j] = String.valueOf(j);
                } else if (j == 0) {
                    visualField[i][0] = String.valueOf((char) (i + 64));
                } else {
                    visualField[i][j] = "~";
                }
            }
        }
    }

    GameField() {
    }

    public void setGameField(String[][] gameField) {
        this.gameField = gameField;
    }
    public void setGameField() throws FileNotFoundException {
        String[][] field = new String[11][11];
        Scanner sc = new Scanner(new BufferedReader(new FileReader("Battleship/task/src/battleship/field.txt")));
        while(sc.hasNextLine()) {
            for (String[] strings : field) {
                String[] line = sc.nextLine().split(" ");
                System.arraycopy(line, 0, strings, 0, line.length);
            }
        }
        this.gameField = field;
    }
    public String[][] getGameField() {
        return gameField;
    }

    public void setHiddenField(String[][] hiddenField) {
        this.hiddenField = hiddenField;
    }
    public String[][] getHiddenField() {
        return hiddenField;
    }

    public String[][] getVisualField() {
        return visualField;
    }

    public void setVisualField(String[][] visualField) {
        this.visualField = visualField;
    }

    public int[][] getAircraftCarrier() {
        return AircraftCarrier;
    }
    public void setAircraftCarrier(int[][] aircraftCarrier) {
        AircraftCarrier = aircraftCarrier;
    }

    public int[][] getBattleship() {
        return Battleship;
    }
    public void setBattleship(int[][] battleship) {
        Battleship = battleship;
    }

    public int[][] getCruiser() {
        return Cruiser;
    }
    public void setCruiser(int[][] cruiser) {
        Cruiser = cruiser;
    }

    public int[][] getDestroyer() {
        return Destroyer;
    }
    public void setDestroyer(int[][] destroyer) {
        Destroyer = destroyer;
    }

    public int[][] getSubmarine() {
        return Submarine;
    }
    public void setSubmarine(int[][] submarine) {
        Submarine = submarine;
    }

    void printField() {
        for (String[] strings : gameField) {
            for (int j = 0; j < strings.length; j++) {
                if (j == gameField.length) {
                    System.out.print(strings[j]);
                } else {
                    System.out.print(strings[j] + " ");
                }
            }
            System.out.println();
        }
    }
    void printHiddenField(){
        for (String[] strings : hiddenField) {
            for (int j = 0; j < strings.length; j++) {
                if (j == hiddenField.length) {
                    System.out.print(strings[j]);
                } else {
                    System.out.print(strings[j] + " ");
                }
            }
            System.out.println();
        }
    }
    void printVisualField(){
        for (String[] strings : visualField) {
            for (int j = 0; j < strings.length; j++) {
                if (j == visualField.length) {
                    System.out.print(strings[j]);
                } else {
                    System.out.print(strings[j] + " ");
                }
            }
            System.out.println();
        }
    }

    boolean checkShip(){

        return false;
    }

}
