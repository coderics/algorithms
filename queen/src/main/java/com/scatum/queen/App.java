package com.scatum.queen;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();

        chessBoard.setPieces();

        chessBoard.printBoard();

        ArrayList<String> listOfMoves = chessBoard.getAllPossibleMoves(Piece.WHITE_QUEEN);

        printMoveList(listOfMoves);

    }

    private static void printMoveList(ArrayList<String> list) {

        System.out.println();

        if (list == null || list.isEmpty()) {
            System.out.println("There are no possible moves.");
        }

        for (String s : list) {
            System.out.print(s + " ");

        }
        System.out.println();
    }
}
