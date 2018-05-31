using System;
using System.Collections.Generic;

namespace QueenApplication
{
    class Movement
    {
        public static void SetRookAttackZone(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            if (y > 0)
            {
                String tempPiece = table[x, y - 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x, y - 1] = piece.AttackingZone();
                    y--;
                    if (y > 0)
                    {
                        tempPiece = table[x, y - 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x, y + 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x, y + 1] = piece.AttackingZone();
                    y++;
                    if (y < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x, y + 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x > 0)
            {
                String tempPiece = table[x - 1, y];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 1, y] = piece.AttackingZone();
                    x--;
                    if (x > 0)
                    {
                        tempPiece = table[x - 1, y];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x + 1, y];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 1, y] = piece.AttackingZone();
                    x++;
                    if (x < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x + 1, y];
                    }
                    else break;
                }
            }


        }

        public static void SetHorseAttackZone(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            if (x > 1 && y > 0)
            {
                String tempPiece = table[x - 2, y - 1];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 2, y - 1] = piece.AttackingZone();
                }
            }

            if (x > 1 && y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x - 2, y + 1];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 2, y + 1] = piece.AttackingZone();
                }
            }

            if (x > 0 && y > 1)
            {
                String tempPiece = table[x - 1, y - 2];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 1, y - 2] = piece.AttackingZone();
                }
            }

            if (x < ChessBoard.SIZE - 1 && y > 1)
            {
                String tempPiece = table[x + 1, y - 2];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 1, y - 2] = piece.AttackingZone();
                }
            }

            if (x < ChessBoard.SIZE - 2 && y > 0)
            {
                String tempPiece = table[x + 2, y - 1];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 2, y - 1] = piece.AttackingZone();
                }
            }

            if (x < ChessBoard.SIZE - 2 && y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x + 2, y + 1];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 2, y + 1] = piece.AttackingZone();
                }
            }

            if (x > 0 && y < ChessBoard.SIZE - 2)
            {
                String tempPiece = table[x - 1, y + 2];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 1, y + 2] = piece.AttackingZone();
                }
            }

            if (x < ChessBoard.SIZE - 1 && y < ChessBoard.SIZE - 2)
            {
                String tempPiece = table[x + 1, y + 2];

                if (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 1, y + 2] = piece.AttackingZone();
                }
            }

        }

        public static void SetBishopAttackZone(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            if (x > 0 && y > 0)
            {
                String tempPiece = table[x - 1, y - 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 1, y - 1] = piece.AttackingZone();
                    x--;
                    y--;
                    if (x > 0 && y > 0)
                    {
                        tempPiece = table[x - 1, y - 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x > 0 && y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x - 1, y + 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x - 1, y + 1] = piece.AttackingZone();
                    x--;
                    y++;
                    if (x > 0 && y < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x - 1, y + 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x < ChessBoard.SIZE - 1 && y > 0)
            {
                String tempPiece = table[x + 1, y - 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 1, y - 1] = piece.AttackingZone();
                    x++;
                    y--;
                    if (x < ChessBoard.SIZE - 1 && y > 0)
                    {
                        tempPiece = table[x + 1, y - 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x < ChessBoard.SIZE - 1 && y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x + 1, y + 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.AttackingZone()))
                {
                    table[x + 1, y + 1] = piece.AttackingZone();
                    x++;
                    y++;
                    if (x < ChessBoard.SIZE - 1 && y < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x + 1, y + 1];
                    }
                    else break;
                }
            }
        }

        public static void SetPawnAttackZone(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            if (x < ChessBoard.SIZE - 1 && piece == Piece.BLACK_PAWN)
            {
                if (y > 0)
                {
                    if (table[x + 1, y - 1] == Piece.EMPTY.Value())
                    {
                        table[x + 1, y - 1] = Piece.BLACK_ATTACK_ZONE.Value();
                    }
                }
                if (y < ChessBoard.SIZE - 1)
                {
                    if (table[x + 1, y + 1] == Piece.EMPTY.Value())
                    {
                        table[x + 1, y + 1] = Piece.BLACK_ATTACK_ZONE.Value();
                    }
                }
            }

            if (x > 0 && piece == Piece.WHITE_PAWN)
            {
                if (y > 0)
                {
                    if (table[x - 1, y - 1] == Piece.EMPTY.Value())
                    {
                        table[x - 1, y - 1] = Piece.WHITE_ATTACK_ZONE.Value();
                    }
                }
                if (y < ChessBoard.SIZE - 1)
                {
                    if (table[x - 1, y + 1] == Piece.EMPTY.Value())
                    {
                        table[x - 1, y + 1] = Piece.WHITE_ATTACK_ZONE.Value();
                    }
                }
            }
        }

        public static void SetQueenAttackZone(int[] coord, String[,] table, Piece piece)
        {
            SetBishopAttackZone(coord, table, piece);
            SetRookAttackZone(coord, table, piece);
        }

        public static void SetKingAttackZone(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            for (int i = x - 1; i <= x + 1; i++)
            {
                for (int j = y - 1; j <= y + 1; j++)
                {
                    if (IsCoordExist(i, j) && table[i, j] == Piece.EMPTY.Value())
                    {
                        table[i, j] = piece.AttackingZone();
                    }
                }
            }

        }

        private static bool IsCoordExist(int x, int y)
        {
            if (x > -1 && x < ChessBoard.SIZE && y > -1 && y < ChessBoard.SIZE)
            {
                return true;
            }
            return false;
        }

        public static List<Coord> GetQueenAllPossibleMoves(int[] coord, String[,] table, Piece piece)
        {
            List<Coord> result = new List<Coord>();

            result.AddRange(GetRookAllPossibleMoves(coord, table, piece));
            result.AddRange(GetBishopAllPossibleMoves(coord, table, piece));

            return result;
        }

        public static List<Coord> GetBishopAllPossibleMoves(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            List<Coord> result = new List<Coord>();

            if (x > 0 && y > 0)
            {
                String tempPiece = table[x - 1, y - 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x - 1, y - 1));
                    }
                    x--;
                    y--;
                    if (x > 0 && y > 0)
                    {
                        tempPiece = table[x - 1, y - 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x > 0 && y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x - 1, y + 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x - 1, y + 1));
                    }
                    x--;
                    y++;
                    if (x > 0 && y < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x - 1, y + 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x < ChessBoard.SIZE - 1 && y > 0)
            {
                String tempPiece = table[x + 1, y - 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x + 1, y - 1));
                    }
                    x++;
                    y--;
                    if (x < ChessBoard.SIZE - 1 && y > 0)
                    {
                        tempPiece = table[x + 1, y - 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x < ChessBoard.SIZE - 1 && y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x + 1, y + 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x + 1, y + 1));
                    }
                    x++;
                    y++;
                    if (x < ChessBoard.SIZE - 1 && y < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x + 1, y + 1];
                    }
                    else break;
                }
            }

            return result;
        }

        public static List<Coord> GetRookAllPossibleMoves(int[] coord, String[,] table, Piece piece)
        {
            int x = coord[0];
            int y = coord[1];

            List<Coord> result = new List<Coord>();

            if (y > 0)
            {
                String tempPiece = table[x, y - 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x, y - 1));
                    }
                    y--;
                    if (y > 0)
                    {
                        tempPiece = table[x, y - 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (y < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x, y + 1];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x, y + 1));
                    }
                    y++;
                    if (y < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x, y + 1];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x > 0)
            {
                String tempPiece = table[x - 1, y];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x - 1, y));
                    }
                    x--;
                    if (x > 0)
                    {
                        tempPiece = table[x - 1, y];
                    }
                    else break;
                }
            }

            x = coord[0];
            y = coord[1];

            if (x < ChessBoard.SIZE - 1)
            {
                String tempPiece = table[x + 1, y];

                while (tempPiece.Equals(Piece.EMPTY.Value()) || tempPiece.Equals(piece.OpponentAttackingZone()))
                {
                    if (tempPiece.Equals(Piece.EMPTY.Value()))
                    {
                        result.Add(new Coord(x + 1, y));
                    }
                    x++;
                    if (x < ChessBoard.SIZE - 1)
                    {
                        tempPiece = table[x + 1, y];
                    }
                    else break;
                }
            }

            return result;
        }
    }
}
