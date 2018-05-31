using System;
using System.Collections.Generic;

namespace QueenApplication
{
    class Program
    {
        static void Main(string[] args)
        {
            ChessBoard chessBoard = new ChessBoard();

            chessBoard.SetPieces();

            chessBoard.PrintBoard();

            List<String> listOfMoves = chessBoard.GetAllPossibleMoves(Piece.WHITE_QUEEN);

            PrintMoveList(listOfMoves);
        }

        static void PrintMoveList(List<String> list)
        {
            Console.WriteLine();

            if (list == null || list.Count == 0)
            {
                Console.WriteLine("There are no possible moves.");
                return;
            }

            Console.WriteLine("All possible moves.");
            foreach (String s in list)
            {
                Console.Write(s + " ");

            }
            Console.WriteLine();
        }
    }
}
