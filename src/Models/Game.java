package Models;

import enums.Color;
import enums.Status;

import java.util.HashMap;
import java.util.List;

public class Game {
    private Status status;
    private List<HashMap<Place,Pawn>> gameNotation;
    private Board currentBoard;
    private List<Character> pawnsCaptured;

    public Game() {
    }

    public void start(){
        this.currentBoard = new Board();

        Piece aPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 1), '♙', Color.WHITE);
        Piece bPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 2), '♙', Color.WHITE);
        Piece cPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 3), '♙', Color.WHITE);
        Piece dPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 4), '♙', Color.WHITE);
        Piece ePawn = new Pawn((Place)currentBoard.getSinglePlace(2, 5), '♙', Color.WHITE);
        Piece fPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 6), '♙', Color.WHITE);
        Piece gPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 7), '♙', Color.WHITE);
        Piece hPawn = new Pawn((Place)currentBoard.getSinglePlace(2, 8), '♙', Color.WHITE);
        Piece a_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 1), '♟', Color.BLACK);
        Piece b_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 2), '♟', Color.BLACK);
        Piece c_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 3), '♟', Color.BLACK);
        Piece d_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 4), '♟', Color.BLACK);
        Piece e_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 5), '♟', Color.BLACK);
        Piece f_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 6), '♟', Color.BLACK);
        Piece g_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 7), '♟', Color.BLACK);
        Piece h_Pawn = new Pawn((Place)currentBoard.getSinglePlace(7, 8), '♟', Color.BLACK);

        //'xYz' is for white and 'x_Yz' is for black
        currentBoard.assignPlaceWithPieces(
                aPawn, bPawn,
                cPawn, dPawn,
                ePawn, fPawn,
                gPawn, hPawn,
                a_Pawn, b_Pawn,
                c_Pawn, d_Pawn,
                e_Pawn, f_Pawn,
                g_Pawn, h_Pawn);


        matrixFormater(currentBoard.getChessBoard());
        }

    private   void matrixFormater(Object[][] chessBoard){
       chessBoard =  this.currentBoard.getChessBoard();
        for(int i  = chessBoard.length - 1; i >= 0; i -- ){
            Object[]row = chessBoard[i];
            for (Object element : row){
                System.out.printf("%-1s\t", element);
            }
            System.out.println();
        }
    }
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<HashMap<Place, Pawn>> getGameNotation() {
        return gameNotation;
    }

    public void setGameNotation(List<HashMap<Place, Pawn>> gameNotation) {
        this.gameNotation = gameNotation;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(Board currentBoard) {
        currentBoard = currentBoard;
    }

    public List<Character> getPawnsCaptured() {
        return pawnsCaptured;
    }

    public void setPawnsCaptured(List<Character> pawnsCaptured) {
        this.pawnsCaptured = pawnsCaptured;
    }
}
