package battleship;

import java.util.Scanner;

public class ShipPosition {
    static private final Scanner scanner;

    static  {
        scanner = new Scanner(System.in);
    }

    static void takePosition(GameField field){
        field.printField();
        System.out.println();

        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.println();
        while (positioning("Aircraft Carrier", 5, field));
        field.printField();
        System.out.println();

        System.out.println("Enter the coordinates of the Battleship (4 cells):");

        while (positioning("Battleship" , 4, field));
        field.printField();
        System.out.println();

        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        System.out.println();
        while (positioning("Submarine", 3, field));
        field.printField();
        System.out.println();

        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        System.out.println();
        while (positioning("Cruiser", 3, field));
        field.printField();
        System.out.println();

        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        System.out.println();
        while (positioning("Destroyer", 2, field));
        field.printField();
        System.out.println();
    }

    static private boolean positioning(String ship, int cells, GameField field) {
        boolean isNotFinished = false;
        String[] input = scanner.nextLine().trim().split(" ");
        System.out.println();
        if (checkInput(input).equals("valid")) {
            if (checkLocation(input)) {
                if (checkLength(input, cells).equals("valid")) {
                    if (checkNearbyLocations(input, field)){
                        placeShip(input, field, cells, ship);
                    }
                    else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        System.out.println();
                        isNotFinished = true;
                    }
                } else {
                    System.out.println("Error! Wrong length of the " + ship + "! Try again:");
                    System.out.println();
                    isNotFinished = true;
                }
            } else {
                System.out.println("Error! Wrong ship location! Try again:");
                System.out.println();
                isNotFinished = true;
            }
        } else {
            System.out.println("invalid input");
            System.out.println();
            isNotFinished = true;
        }

        return isNotFinished;
    }

    static private String checkInput(String[] input) {
        String check = "";
        if (input.length != 2) {
            //check = "oneArgument";
            check = "you must enter two coordinates";
        } else {
            input[0] = input[0].replaceAll("10", ":");
            input[1] = input[1].replaceAll("10", ":");
            for (int i = 0; i < input.length; i++) {
                if (input[i].length() != 2) {
                    //check = "oneArgument " + (i + 1);
                    check = "wrong coordinate " + (i + 1);
                    break;
                } else {
                    if (!(input[i].charAt(0) >= 65 && input[i].charAt(0) <= 74)) {
                        check = input[i].charAt(0) + " first option  on coordinate " + (i + 1) + " is out of rang";
                        break;
                    }
                    if (!(input[i].charAt(1) >= 48 && input[i].charAt(1) <= 58)) {
                        check = input[i].charAt(1) + " second option  on coordinate " + (i + 1) + " must be a number";
                        break;
                    } else {
                        check = "valid";
                    }
                }
            }
        }
        return check;
    }

    static private boolean checkLocation(String[] input) {
        //Coordinate
        String fstCrd = input[0];
        String sndCrd = input[1];
        return fstCrd.charAt(0) == sndCrd.charAt(0) || fstCrd.charAt(1) == sndCrd.charAt(1);
    }

    static private String checkLength(String[] input, int cells) {
        String check = "valid";
        String fstCrd = input[0];
        String sndCrd = input[1];

        if (fstCrd.charAt(0) == sndCrd.charAt(0)) {
            char ch1 = fstCrd.charAt(1);
            char ch2 = sndCrd.charAt(1);
            if (Math.abs(ch1 - ch2) + 1 != cells) {
                check = "wrong";
            }
        } else {
            if (Math.abs(fstCrd.charAt(0) - sndCrd.charAt(0)) + 1 != cells) {
                check = "wrong";
            }
        }

        return check;
    }

    static private boolean checkNearbyLocations(String[] input, GameField field) {
        boolean check = true;

        int fstCrdRow = (input[0].charAt(0) - 64);
        int fstCrdClm = (input[0].charAt(1) - 48);
        int sndCrdRow = (input[1].charAt(0) - 64);
        int sndCrdClm = (input[1].charAt(1) - 48);

        int fstClm = 0;
        int lstClm = 0;
        int fstRow = 0;
        int lstRow = 0;
        if (fstCrdRow == sndCrdRow) {
            fstClm = Math.min(fstCrdClm, sndCrdClm);
            lstClm = Math.max(fstCrdClm, sndCrdClm);
            if (fstCrdRow == 1){
                fstRow = fstCrdRow;
                lstRow = fstCrdRow + 1;
            }
            else if (fstCrdRow == 10){
                fstRow = fstCrdRow - 1;
                lstRow = fstCrdRow;
            }
            else {
                fstRow = fstCrdRow - 1;
                lstRow = lstRow + 1;
            }
            if (fstClm == 1){
                lstClm = lstClm + 1;
            }
            else if (lstClm == 10){
                fstClm = fstClm - 1;
            }
            else {
                fstClm = fstClm - 1;
                lstClm = lstClm + 1;
            }
        }
        else if (fstCrdClm == sndCrdClm) {
            fstRow = Math.min(fstCrdRow, sndCrdRow);
            lstRow = Math.max(fstCrdRow, sndCrdRow);

            if (fstCrdClm == 1){
                fstClm = fstCrdClm;
                lstClm = fstCrdClm + 1;
            }
            else if (fstCrdClm == 10){
                fstClm = fstCrdClm - 1;
                lstClm = fstCrdClm;
            }
            else {
                fstClm = fstCrdClm - 1;
                lstClm = fstCrdClm + 1;
            }
            if (fstRow == 1){
                lstRow = lstRow + 1;
            }
            else if (lstRow == 10){
                fstRow = fstRow - 1;
            }
            else {
                fstRow = fstRow - 1;
                lstRow = lstRow + 1;
            }
        }
        for (int i = fstRow; i <= lstRow; i++){
            for (int j = fstClm; j <= lstClm; j++){
                if (!field.getGameField()[i][j].equals("~")) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }

    static private void placeShip(String[] input, GameField field, int cells, String ship){
        int fstCrdRow = (input[0].charAt(0) - 64);
        int fstCrdClm = (input[0].charAt(1) - 48);
        int sndCrdRow = (input[1].charAt(0) - 64);
        int sndCrdClm = (input[1].charAt(1) - 48);

        int fstClm = Math.min(fstCrdClm, sndCrdClm);
        int lstClm = Math.max(fstCrdClm, sndCrdClm);
        int fstRow = Math.min(fstCrdRow, sndCrdRow);
        int lstRow = Math.max(fstCrdRow, sndCrdRow);

        setShip(input, ship, field);

        for (int i = fstRow; i <= lstRow; i++){
            for (int j = fstClm; j <= lstClm; j++){
                field.getGameField()[i][j] = "O";
                switch (ship){
                    case "Aircraft Carrier":
                        field.getVisualField()[i][j] = "A";
                        break;
                    case "Battleship":
                        field.getVisualField()[i][j] = "B";
                        break;
                    case "Submarine":
                        field.getVisualField()[i][j] = "S";
                        break;
                    case "Cruiser":
                        field.getVisualField()[i][j] = "C";
                        break;
                    case "Destroyer":
                        field.getVisualField()[i][j] = "D";
                        break;
                    default:
                        break;
                }

            }
        }
    }
    static private void setShip(String[] input, String ship, GameField field){
        int fstCrdRow = (input[0].charAt(0) - 64);
        int fstCrdClm = (input[0].charAt(1) - 48);
        int sndCrdRow = (input[1].charAt(0) - 64);
        int sndCrdClm = (input[1].charAt(1) - 48);

        int fstClm = Math.min(fstCrdClm, sndCrdClm);
        int lstClm = Math.max(fstCrdClm, sndCrdClm);
        int fstRow = Math.min(fstCrdRow, sndCrdRow);
        int lstRow = Math.max(fstCrdRow, sndCrdRow);

        int[][] shipCoordinates = (new int[][]{{fstRow, fstClm},{lstRow, lstClm}});
        switch (ship){
            case "Aircraft Carrier":
                field.setAircraftCarrier(shipCoordinates);
                break;
            case "Battleship":
                field.setBattleship(shipCoordinates);
                break;
            case "Submarine":
                field.setSubmarine(shipCoordinates);
                break;
            case "Cruiser":
                field.setCruiser(shipCoordinates);
                break;
            case "Destroyer":
                field.setDestroyer(shipCoordinates);
                break;
            default:
                break;
        }
    }
}
