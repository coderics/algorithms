package com.scatum.queen;

import java.util.ArrayList;

import static com.scatum.queen.Piece.*;

class ChessBoard {

    static final int size = 8;

    private String[][] table;

    ChessBoard() {
        initBoard();
    }

    private void initBoard() {
        table = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = EMPTY.value();
            }
        }
    }

    void printBoard() {
        System.out.print("\t");
        for (int c = 97; c < 105; c++) {
            System.out.print((char) c + "  ");
        }
        System.out.println("\n\t-----------------------");

        for (int i = 0; i < size; i++) {

            System.out.print(size - i + "|\t");

            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * setting chess pieces on board
     */
    void setPieces() {

        //black pieces
        table[0][0] = BLACK_ROOK.value();
        table[2][2] = BLACK_HORSE.value();
        table[0][2] = BLACK_BISHOP.value();
        table[0][3] = BLACK_QUEEN.value();
        table[0][4] = BLACK_KING.value();
        table[0][5] = BLACK_BISHOP.value();
        table[0][6] = BLACK_HORSE.value();
        table[0][7] = BLACK_ROOK.value();

        table[1][0] = BLACK_PAWN.value();
        table[1][1] = BLACK_PAWN.value();
        table[1][2] = BLACK_PAWN.value();
        table[1][3] = BLACK_PAWN.value();
        table[1][4] = BLACK_PAWN.value();
        table[1][5] = BLACK_PAWN.value();
        table[1][6] = BLACK_PAWN.value();
        table[1][7] = BLACK_PAWN.value();

        //white pieces
        table[7][0] = WHITE_ROOK.value();
        table[7][1] = WHITE_HORSE.value();
        table[7][2] = WHITE_BISHOP.value();
        table[5][5] = WHITE_QUEEN.value();
        table[7][4] = WHITE_KING.value();
        table[7][5] = WHITE_BISHOP.value();
        table[7][6] = WHITE_HORSE.value();
        table[7][7] = WHITE_ROOK.value();

        table[6][0] = WHITE_PAWN.value();
        table[6][1] = WHITE_PAWN.value();
        table[6][2] = WHITE_PAWN.value();
        table[6][3] = WHITE_PAWN.value();
        table[4][4] = WHITE_PAWN.value();
        table[6][5] = WHITE_PAWN.value();
        table[6][6] = WHITE_PAWN.value();
        table[6][7] = WHITE_PAWN.value();
    }

    ArrayList<String> getAllPossibleMoves(Piece piece) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (table[i][j] == piece.value()) {
                    if (piece.color() == Color.WHITE) {
                        setBlackAttackZones();
                    }
                    if (piece.color() == Color.BLACK) {
                        setWhiteAttackZones();
                    }

                    ArrayList<Coord> coordList = PieceMove.getQueenAllPossibleMoves(new int[]{i, j}, table, piece);

                    removeAttackZones();

                    return convertToReadableCoord(coordList);
                }
            }
        }

        return null;
    }

    private static ArrayList<String> convertToReadableCoord(ArrayList<Coord> coords) {
        ArrayList<String> result = new ArrayList<>();

        for (Coord c : coords) {
            String yy = Letter.getName(c.y);
            String xx = Integer.toString(Math.abs(c.x - size));

            result.add("( " + yy + "," + xx + " )");
        }

        return result;
    }

    private void setBlackAttackZones() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == BLACK_ROOK.value()) {
                    PieceMove.setRookAttackZone(new int[]{i, j}, table, BLACK_ROOK);
                }

                if (table[i][j] == BLACK_HORSE.value()) {
                    PieceMove.setHorseAttackZone(new int[]{i, j}, table, BLACK_HORSE);
                }

                if (table[i][j] == BLACK_BISHOP.value()) {
                    PieceMove.setBishopAttackZone(new int[]{i, j}, table, BLACK_BISHOP);
                }

                if (table[i][j] == BLACK_QUEEN.value()) {
                    PieceMove.setQueenAttackZone(new int[]{i, j}, table, BLACK_QUEEN);
                }

                if (table[i][j] == BLACK_KING.value()) {
                    PieceMove.setKingAttackZone(new int[]{i, j}, table, BLACK_KING);
                }

                if (table[i][j] == BLACK_PAWN.value()) {
                    PieceMove.setPawnAttackZone(new int[]{i, j}, table, BLACK_PAWN);
                }
            }
        }

    }

    private void setWhiteAttackZones() {
        //need to implement
    }

    private void removeAttackZones() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j] == BLACK_ATTACK_ZONE.value() || table[i][j] == WHITE_ATTACK_ZONE.value()) {
                    table[i][j] = EMPTY.value();
                }
            }
        }
    }
}
