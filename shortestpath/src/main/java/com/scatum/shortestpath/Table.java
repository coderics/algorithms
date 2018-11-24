package com.scatum.shortestpath;

import java.util.ArrayList;
import java.util.Collections;

import static com.scatum.shortestpath.Symbol.*;

class Table {

    private static final int size = 20;

    private String[][] table;

    Table() {
        initTable();
        setDefaultCoords();
    }

    private void initTable() {
        table = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = EMPTY.value;
            }
        }
    }

    void print() {
        System.out.println("Printing Table..");
        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%3d", i);
        }
        System.out.print("\n   ___________________________________________________________\n");
        for (int i = 0; i < size; i++) {

            System.out.printf("%2d|", i);

            for (int j = 0; j < size; j++) {
                System.out.printf("%3s", table[i][j]);
            }

            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }

    private void setDefaultCoords() {

        table[15][5] = A.value;
        table[6][15] = B.value;

        table[10][9] = CLOSED.value;
        table[10][10] = CLOSED.value;
        table[10][11] = CLOSED.value;
        table[10][12] = CLOSED.value;
        table[7][14] = CLOSED.value;
        table[7][16] = CLOSED.value;
        table[8][15] = CLOSED.value;
        table[9][15] = CLOSED.value;
    }

    void clean() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!isExist(table[i][j])) {
                    table[i][j] = EMPTY.value;
                }
            }
        }
    }

    void setCoord(Coord c, Symbol s) {
        if (table[c.x][c.y].equals(EMPTY.value)) {
            remove(s);

            table[c.x][c.y] = s.value;
        } else {
            System.out.println("Coordinate is always taken.");
        }
    }

    private Coord getCoord(Symbol s) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j].equals(s.value)) {
                    return new Coord(i, j);
                }
            }
        }
        return null;
    }

    private void remove(Symbol s) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j].equals(s.value)) {
                    table[i][j] = EMPTY.value;
                }
            }
        }
    }

    /**
     * main algorithmic function which find and write the path on the table
     */
    void findPath() {
        Coord A = getCoord(Symbol.A);

        int x = A.x;
        int y = A.y;

        String cell = "";
        Integer counter = 1;

        ArrayList<Coord> coordList = new ArrayList<>(); //list for saving coordinates
        Integer listCounter = 0;

        while (!cell.equals(B.value)) {

            if (x + 1 < size && isValid(table[x + 1][y])) {

                if (table[x + 1][y].equals(EMPTY.value)) {
                    table[x + 1][y] = counter.toString(); //1 2 3..
                }

                coordList.add(new Coord(x + 1, y)); //saving next coordinate
            }

            if (x - 1 >= 0 && isValid(table[x - 1][y])) {

                if (table[x - 1][y].equals(EMPTY.value)) {
                    table[x - 1][y] = counter.toString();  //1 2 3..
                }

                coordList.add(new Coord(x - 1, y));  //saving next coordinate
            }

            if (y + 1 < size && isValid(table[x][y + 1])) {

                if (table[x][y + 1].equals(EMPTY.value)) {
                    table[x][y + 1] = counter.toString();  //1 2 3..
                }

                coordList.add(new Coord(x, y + 1));  //saving next coordinate
            }

            if (y - 1 >= 0 && isValid(table[x][y - 1])) {

                if (table[x][y - 1].equals(EMPTY.value)) {
                    table[x][y - 1] = counter.toString();  //1 2 3..
                }

                coordList.add(new Coord(x, y - 1));  //saving next coordinate
            }

            Coord c = coordList.get(listCounter); // getting next coordinate from list
            x = c.x;
            y = c.y;
            cell = table[x][y]; //assigning new value
            listCounter++;  // iterating list counter

            if (isNumber(cell)) {
                counter = Integer.parseInt(cell) + 1; //assigning symbol counter (1,2,3..)
            }
        }
    }

    /**
     * This function collect all neighbor coordinates of B point
     * and return the minimum of them
     */
    Integer getShortestPath() {

        Coord B = getCoord(Symbol.B);

        ArrayList<String> stringValues = new ArrayList<>();
        ArrayList<Integer> intValues = new ArrayList<>();

        int x = B.x;
        int y = B.y;

        if (x - 1 >= 0) {
            stringValues.add(table[x - 1][y]);
        }
        if (x + 1 < size) {
            stringValues.add(table[x + 1][y]);
        }
        if (y - 1 >= 0) {
            stringValues.add(table[x][y - 1]);
        }
        if (y + 1 < size) {
            stringValues.add(table[x][y + 1]);
        }

        for (String s : stringValues) {
            if (isNumber(s)) {
                intValues.add(Integer.parseInt(s));
            }
        }

        return Collections.min(intValues);
    }

    private boolean isValid(String symbol) {
        return symbol.equals(EMPTY.value) || symbol.equals(B.value);
    }

    private boolean isNumber(String cell) {
        try {
            Integer.parseInt(cell);
        } catch (Exception ignored) {
            return false;
        }

        return true;
    }

    static boolean isCoordExist(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
}
