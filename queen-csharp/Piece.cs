using System;

namespace QueenApplication
{
    class Piece
    {
        public enum Color { BLACK, WHITE, NONE }

        public static readonly Piece BLACK_KING = new Piece("bK", Color.BLACK);
        public static readonly Piece BLACK_QUEEN = new Piece("bQ", Color.BLACK);
        public static readonly Piece BLACK_ROOK = new Piece("bR", Color.BLACK);
        public static readonly Piece BLACK_BISHOP = new Piece("bB", Color.BLACK);
        public static readonly Piece BLACK_HORSE = new Piece("bH", Color.BLACK);
        public static readonly Piece BLACK_PAWN = new Piece("bP", Color.BLACK);

        public static readonly Piece WHITE_KING = new Piece("wK", Color.WHITE);
        public static readonly Piece WHITE_QUEEN = new Piece("wQ", Color.WHITE);
        public static readonly Piece WHITE_ROOK = new Piece("wR", Color.WHITE);
        public static readonly Piece WHITE_BISHOP = new Piece("wB", Color.WHITE);
        public static readonly Piece WHITE_HORSE = new Piece("wH", Color.WHITE);
        public static readonly Piece WHITE_PAWN = new Piece("wP", Color.WHITE);

        public static readonly Piece EMPTY = new Piece("..", Color.NONE);
        public static readonly Piece BLACK_ATTACK_ZONE = new Piece("--", Color.NONE);
        public static readonly Piece WHITE_ATTACK_ZONE = new Piece("++", Color.NONE);


        private readonly String value;
        private readonly Color color;

        Piece(String value, Color color)
        {
            this.value = value;
            this.color = color;
        }

        public String Value()
        {
            return value;
        }

        public Color GetColor()
        {
            return color;
        }

        public String AttackingZone()
        {
            if (this.color == Color.WHITE)
            {
                return WHITE_ATTACK_ZONE.Value();
            }
            if (this.color == Color.BLACK)
            {
                return BLACK_ATTACK_ZONE.Value();
            }

            return null;
        }

        public String OpponentAttackingZone()
        {
            if (this.color == Color.WHITE)
            {
                return BLACK_ATTACK_ZONE.Value();
            }
            if (this.color == Color.BLACK)
            {
                return WHITE_ATTACK_ZONE.Value();
            }

            return null;
        }
    }
}
