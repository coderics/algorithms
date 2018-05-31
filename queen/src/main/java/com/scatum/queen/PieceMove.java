package com.scatum.queen;

import java.util.ArrayList;

import static com.scatum.queen.ChessBoard.size;
import static com.scatum.queen.Piece.*;

class PieceMove {

    static void setRookAttackZone(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        if (y > 0) {
            String tempPiece = table[x][y - 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x][y - 1] = piece.attackingZone();
                y--;
                if (y > 0) {
                    tempPiece = table[x][y - 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (y < size - 1) {
            String tempPiece = table[x][y + 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x][y + 1] = piece.attackingZone();
                y++;
                if (y < size - 1) {
                    tempPiece = table[x][y + 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x > 0) {
            String tempPiece = table[x - 1][y];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 1][y] = piece.attackingZone();
                x--;
                if (x > 0) {
                    tempPiece = table[x - 1][y];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x < size - 1) {
            String tempPiece = table[x + 1][y];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 1][y] = piece.attackingZone();
                x++;
                if (x < size - 1) {
                    tempPiece = table[x + 1][y];
                } else break;
            }
        }


    }

    static void setHorseAttackZone(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        if (x > 1 && y > 0) {
            String tempPiece = table[x - 2][y - 1];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 2][y - 1] = piece.attackingZone();
            }
        }

        if (x > 1 && y < size - 1) {
            String tempPiece = table[x - 2][y + 1];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 2][y + 1] = piece.attackingZone();
            }
        }

        if (x > 0 && y > 1) {
            String tempPiece = table[x - 1][y - 2];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 1][y - 2] = piece.attackingZone();
            }
        }

        if (x < size - 1 && y > 1) {
            String tempPiece = table[x + 1][y - 2];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 1][y - 2] = piece.attackingZone();
            }
        }

        if (x < size - 2 && y > 0) {
            String tempPiece = table[x + 2][y - 1];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 2][y - 1] = piece.attackingZone();
            }
        }

        if (x < size - 2 && y < size - 1) {
            String tempPiece = table[x + 2][y + 1];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 2][y + 1] = piece.attackingZone();
            }
        }

        if (x > 0 && y < size - 2) {
            String tempPiece = table[x - 1][y + 2];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 1][y + 2] = piece.attackingZone();
            }
        }

        if (x < size - 1 && y < size - 2) {
            String tempPiece = table[x + 1][y + 2];

            if (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 1][y + 2] = piece.attackingZone();
            }
        }

    }

    public static void setBishopAttackZone(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        if (x > 0 && y > 0) {
            String tempPiece = table[x - 1][y - 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 1][y - 1] = piece.attackingZone();
                x--;
                y--;
                if (x > 0 && y > 0) {
                    tempPiece = table[x - 1][y - 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x > 0 && y < size - 1) {
            String tempPiece = table[x - 1][y + 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x - 1][y + 1] = piece.attackingZone();
                x--;
                y++;
                if (x > 0 && y < size - 1) {
                    tempPiece = table[x - 1][y + 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x < size - 1 && y > 0) {
            String tempPiece = table[x + 1][y - 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 1][y - 1] = piece.attackingZone();
                x++;
                y--;
                if (x < size - 1 && y > 0) {
                    tempPiece = table[x + 1][y - 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x < size - 1 && y < size - 1) {
            String tempPiece = table[x + 1][y + 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.attackingZone())) {
                table[x + 1][y + 1] = piece.attackingZone();
                x++;
                y++;
                if (x < size - 1 && y < size - 1) {
                    tempPiece = table[x + 1][y + 1];
                } else break;
            }
        }
    }

    public static void setPawnAttackZone(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        if (x < size - 1 && piece == BLACK_PAWN) {
            if (y > 0) {
                if (table[x + 1][y - 1] == EMPTY.value()) {
                    table[x + 1][y - 1] = BLACK_ATTACK_ZONE.value();
                }
            }
            if (y < size - 1) {
                if (table[x + 1][y + 1] == EMPTY.value()) {
                    table[x + 1][y + 1] = BLACK_ATTACK_ZONE.value();
                }
            }
        }

        if (x > 0 && piece == WHITE_PAWN) {
            if (y > 0) {
                if (table[x - 1][y - 1] == EMPTY.value()) {
                    table[x - 1][y - 1] = WHITE_ATTACK_ZONE.value();
                }
            }
            if (y < size - 1) {
                if (table[x - 1][y + 1] == EMPTY.value()) {
                    table[x - 1][y + 1] = WHITE_ATTACK_ZONE.value();
                }
            }
        }
    }

    static void setQueenAttackZone(int[] coord, String[][] table, Piece piece) {
        setBishopAttackZone(coord, table, piece);
        setRookAttackZone(coord, table, piece);
    }

    static void setKingAttackZone(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isCoordExist(i, j) && table[i][j] == EMPTY.value()) {
                    table[i][j] = piece.attackingZone();
                }
            }
        }

    }

    private static boolean isCoordExist(int x, int y) {
        if (x > -1 && x < size && y > -1 && y < size) {
            return true;
        }
        return false;
    }

    static ArrayList<Coord> getQueenAllPossibleMoves(int[] coord, String[][] table, Piece piece) {
        ArrayList<Coord> result = new ArrayList<>();

        result.addAll(getRookAllPossibleMoves(coord, table, piece));
        result.addAll(getBishopAllPossibleMoves(coord, table, piece));

        return result;
    }

    static ArrayList<Coord> getBishopAllPossibleMoves(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        ArrayList<Coord> result = new ArrayList<>();

        if (x > 0 && y > 0) {
            String tempPiece = table[x - 1][y - 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x - 1, y - 1));
                }
                x--;
                y--;
                if (x > 0 && y > 0) {
                    tempPiece = table[x - 1][y - 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x > 0 && y < size - 1) {
            String tempPiece = table[x - 1][y + 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x - 1, y + 1));
                }
                x--;
                y++;
                if (x > 0 && y < size - 1) {
                    tempPiece = table[x - 1][y + 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x < size - 1 && y > 0) {
            String tempPiece = table[x + 1][y - 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x + 1, y - 1));
                }
                x++;
                y--;
                if (x < size - 1 && y > 0) {
                    tempPiece = table[x + 1][y - 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x < size - 1 && y < size - 1) {
            String tempPiece = table[x + 1][y + 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x + 1, y + 1));
                }
                x++;
                y++;
                if (x < size - 1 && y < size - 1) {
                    tempPiece = table[x + 1][y + 1];
                } else break;
            }
        }

        return result;
    }

    static ArrayList<Coord> getRookAllPossibleMoves(int[] coord, String[][] table, Piece piece) {
        int x = coord[0];
        int y = coord[1];

        ArrayList<Coord> result = new ArrayList<>();

        if (y > 0) {
            String tempPiece = table[x][y - 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x, y - 1));
                }
                y--;
                if (y > 0) {
                    tempPiece = table[x][y - 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (y < size - 1) {
            String tempPiece = table[x][y + 1];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x, y + 1));
                }
                y++;
                if (y < size - 1) {
                    tempPiece = table[x][y + 1];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x > 0) {
            String tempPiece = table[x - 1][y];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x - 1, y));
                }
                x--;
                if (x > 0) {
                    tempPiece = table[x - 1][y];
                } else break;
            }
        }

        x = coord[0];
        y = coord[1];

        if (x < size - 1) {
            String tempPiece = table[x + 1][y];

            while (tempPiece.equals(EMPTY.value()) || tempPiece.equals(piece.opponentAttackingZone())) {
                if (tempPiece.equals(EMPTY.value())) {
                    result.add(new Coord(x + 1, y));
                }
                x++;
                if (x < size - 1) {
                    tempPiece = table[x + 1][y];
                } else break;
            }
        }

        return result;
    }
}
