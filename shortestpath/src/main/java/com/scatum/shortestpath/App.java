package com.scatum.shortestpath;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Table table = new Table();
        table.print();

        System.out.println("Coordinates were placed by default");

        Scanner scanner = new Scanner(System.in);

        //console logic
        while (true) {
            printHelp();
            String input = scanner.nextLine();

            if (input.contains("find")) {
                table.findPath();
                table.print();
                System.out.println("Shortest path is " + table.getShortestPath() + " step.");
                table.clean();
            }
            else if (input.contains("A")) {
                System.out.println("Type x,y coordinates (use space): ");
                String coord = scanner.nextLine();

                if (retrieveCoord(coord) != null) {
                    Coord c = retrieveCoord(coord);
                    table.setCoord(c, Symbol.A);
                    table.print();
                } else {
                    System.out.println("Wrong coordinates");
                }
            }
            else if (input.contains("B")) {
                System.out.println("Type x,y coordinates (use space): ");
                String coord = scanner.nextLine();

                if (retrieveCoord(coord) != null) {
                    Coord c = retrieveCoord(coord);
                    table.setCoord(c, Symbol.B);
                    table.print();
                } else {
                    System.out.println("Wrong coordinates");
                }
            }
            else if (input.contains("exit")) {
                break;
            }
            else {
                System.out.println("Wrong input");
            }
        }

        scanner.close();
    }

    private static Coord retrieveCoord(String input) {
        String[] nums = input.split("\\s+");
        if (nums.length != 2) {
            return null;
        }

        try {
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);

            if (!Table.isCoordExist(x, y)) {
                return null;
            }
            return new Coord(x, y);
        } catch (Exception e) {
            return null;
        }
    }

    private static void printHelp() {
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Type 'find' to find the shortest path");
        System.out.println("2. Type 'A' to enter coordinates of A point");
        System.out.println("3. Type 'B' to enter coordinates of B point");
        System.out.println("4. Type 'exit' to close the application");
    }
}
