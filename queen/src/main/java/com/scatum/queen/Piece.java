package com.scatum.queen;


public enum Piece {

    BLACK_KING("bK", Color.BLACK),
    BLACK_QUEEN("bQ", Color.BLACK),
    BLACK_ROOK("bR", Color.BLACK),
    BLACK_BISHOP("bB", Color.BLACK),
    BLACK_HORSE("bH", Color.BLACK),
    BLACK_PAWN("bP", Color.BLACK),

    WHITE_KING("wK", Color.WHITE),
    WHITE_QUEEN("wQ", Color.WHITE),
    WHITE_ROOK("wR", Color.WHITE),
    WHITE_BISHOP("wB", Color.WHITE),
    WHITE_HORSE("wH", Color.WHITE),
    WHITE_PAWN("wP", Color.WHITE),

    EMPTY("..", Color.NONE),
    BLACK_ATTACK_ZONE("--", Color.NONE),
    WHITE_ATTACK_ZONE("++", Color.NONE);

    enum Color {
        BLACK,
        WHITE,
        NONE;
    }

    private String value;
    private Color color;

    private Piece(String value, Color color) {
        this.value = value;
        this.color = color;
    }

    public String value() {
        return value;
    }

    public Color color() {
        return color;
    }

    public String attackingZone() {
        if (this.color == Color.WHITE) {
            return Piece.WHITE_ATTACK_ZONE.value();
        }
        if (this.color == Color.BLACK) {
            return Piece.BLACK_ATTACK_ZONE.value();
        }

        return null;
    }

    public String opponentAttackingZone() {
        if (this.color == Color.WHITE) {
            return Piece.BLACK_ATTACK_ZONE.value();
        }
        if (this.color == Color.BLACK) {
            return Piece.WHITE_ATTACK_ZONE.value();
        }

        return null;
    }
}
