using System;
using System.Collections.Generic;

namespace QueenApplication
{
    class ChessBoard
    {
        public static readonly int SIZE = 8;

        private String[,] table;

        public ChessBoard()
        {
            InitBoard();
        }

        private void InitBoard()
        {
            table = new String[SIZE, SIZE];

            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                {
                    table[i, j] = Piece.EMPTY.Value();
                }
            }
        }

        /**
         * setting chess pieces on board
         */
        public void SetPieces()
        {
            //black pieces
            table[0, 0] = Piece.BLACK_ROOK.Value();
            table[2, 2] = Piece.BLACK_HORSE.Value();
            table[0, 2] = Piece.BLACK_BISHOP.Value();
            table[0, 3] = Piece.BLACK_QUEEN.Value();
            table[0, 4] = Piece.BLACK_KING.Value();
            table[0, 5] = Piece.BLACK_BISHOP.Value();
            table[0, 6] = Piece.BLACK_HORSE.Value();
            table[0, 7] = Piece.BLACK_ROOK.Value();

            table[1, 0] = Piece.BLACK_PAWN.Value();
            table[1, 1] = Piece.BLACK_PAWN.Value();
            table[1, 2] = Piece.BLACK_PAWN.Value();
            table[1, 3] = Piece.BLACK_PAWN.Value();
            table[1, 4] = Piece.BLACK_PAWN.Value();
            table[1, 5] = Piece.BLACK_PAWN.Value();
            table[1, 6] = Piece.BLACK_PAWN.Value();
            table[1, 7] = Piece.BLACK_PAWN.Value();

            //white pieces
            table[7, 0] = Piece.WHITE_ROOK.Value();
            table[7, 1] = Piece.WHITE_HORSE.Value();
            table[7, 2] = Piece.WHITE_BISHOP.Value();
            table[5, 3] = Piece.WHITE_QUEEN.Value();
            table[7, 4] = Piece.WHITE_KING.Value();
            table[7, 5] = Piece.WHITE_BISHOP.Value();
            table[7, 6] = Piece.WHITE_HORSE.Value();
            table[7, 7] = Piece.WHITE_ROOK.Value();

            table[6, 0] = Piece.WHITE_PAWN.Value();
            table[6, 1] = Piece.WHITE_PAWN.Value();
            table[6, 2] = Piece.WHITE_PAWN.Value();
            table[6, 3] = Piece.WHITE_PAWN.Value();
            table[4, 4] = Piece.WHITE_PAWN.Value();
            table[6, 5] = Piece.WHITE_PAWN.Value();
            table[6, 6] = Piece.WHITE_PAWN.Value();
            table[6, 7] = Piece.WHITE_PAWN.Value();
        }

        public void PrintBoard()
        {
            Console.Write("\t");
            for (int c = 97; c < 105; c++)
            {
                Console.Write((char)c + "  ");
            }
            Console.WriteLine("\n\t-----------------------");

            for (int i = 0; i < SIZE; i++)
            {
                Console.Write(SIZE - i + "|\t");

                for (int j = 0; j < SIZE; j++)
                {
                    Console.Write(table[i, j] + " ");
                }

                Console.WriteLine();
            }
        }

        public List<String> GetAllPossibleMoves(Piece piece)
        {

            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                {

                    if (table[i, j] == piece.Value())
                    {
                        if (piece.GetColor() == Piece.Color.WHITE)
                        {
                            SetBlackAttackZones();
                        }
                        if (piece.GetColor() == Piece.Color.BLACK)
                        {
                            SetWhiteAttackZones();
                        }

                        List<Coord> coordList = Movement.GetQueenAllPossibleMoves(new int[] { i, j }, table, piece);

                        RemoveAttackZones();

                        return ConvertToReadableCoord(coordList);
                    }
                }
            }

            return null;
        }

        private void SetBlackAttackZones()
        {

            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                {
                    if (table[i, j] == Piece.BLACK_ROOK.Value())
                    {
                        Movement.SetRookAttackZone(new int[] { i, j }, table, Piece.BLACK_ROOK);
                    }

                    if (table[i, j] == Piece.BLACK_HORSE.Value())
                    {
                        Movement.SetHorseAttackZone(new int[] { i, j }, table, Piece.BLACK_HORSE);
                    }

                    if (table[i, j] == Piece.BLACK_BISHOP.Value())
                    {
                        Movement.SetBishopAttackZone(new int[] { i, j }, table, Piece.BLACK_BISHOP);
                    }

                    if (table[i, j] == Piece.BLACK_QUEEN.Value())
                    {
                        Movement.SetQueenAttackZone(new int[] { i, j }, table, Piece.BLACK_QUEEN);
                    }

                    if (table[i, j] == Piece.BLACK_KING.Value())
                    {
                        Movement.SetKingAttackZone(new int[] { i, j }, table, Piece.BLACK_KING);
                    }

                    if (table[i, j] == Piece.BLACK_PAWN.Value())
                    {
                        Movement.SetPawnAttackZone(new int[] { i, j }, table, Piece.BLACK_PAWN);
                    }
                }
            }

        }

        private void SetWhiteAttackZones()
        {
            //need to implement
        }


        private void RemoveAttackZones()
        {
            for (int i = 0; i < SIZE; i++)
            {
                for (int j = 0; j < SIZE; j++)
                {
                    if (table[i, j] == Piece.BLACK_ATTACK_ZONE.Value() || table[i, j] == Piece.WHITE_ATTACK_ZONE.Value())
                    {
                        table[i, j] = Piece.EMPTY.Value();
                    }
                }
            }
        }

        private static List<String> ConvertToReadableCoord(List<Coord> coordList)
        {
            List<String> result = new List<String>();

            foreach (Coord c in coordList)
            {
                String yy = Utils.GetLetterName(c.y);
                String xx = Math.Abs(c.x - SIZE).ToString();

                result.Add("( " + yy + "," + xx + " )");
            }

            return result;
        }


    }
}
