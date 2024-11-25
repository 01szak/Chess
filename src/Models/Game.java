package Models;

import enums.Color;
import enums.Status;
import exceptions.IllegalMoveException;

import java.util.*;

public class Game {
    private Status status;
    private List<HashMap<Place, Pawn>> gameNotation;
    private Map<Place, Piece> currentStateOfTheGame;

    private Board currentBoard;

    private List<Character> pawnsCaptured;
    private List<Piece> allPieces;

    public Game() {
    }

    public void start() throws IllegalMoveException {
        this.currentBoard = new Board();
        this.allPieces = new ArrayList<>();
        this.currentStateOfTheGame = new HashMap<>();
        String currentStateOfTheGame = Status.ACTIVE.toString();
        Piece aPawn = new Pawn(new Place(2,'a'), '♙', Color.WHITE,true,false);
        allPieces.add(aPawn);
        Piece bPawn = new Pawn(new Place(2,'b'), '♙', Color.WHITE,true,false);
        allPieces.add(bPawn);
        Piece cPawn = new Pawn(new Place(2,'c'), '♙', Color.WHITE,true,false);
        allPieces.add(cPawn);
        Piece dPawn = new Pawn(new Place(2,'d'), '♙', Color.WHITE,true,false);
        allPieces.add(dPawn);
        Piece ePawn = new Pawn(new Place(2,'e'), '♙', Color.WHITE,true,false);
        allPieces.add(ePawn);
        Piece fPawn = new Pawn(new Place(2,'f'), '♙', Color.WHITE,true,false);
        allPieces.add(fPawn);
        Piece gPawn = new Pawn(new Place(2,'g'), '♙', Color.WHITE,true,false);
        allPieces.add(gPawn);
        Piece hPawn = new Pawn(new Place(2,'h'), '♙', Color.WHITE,true,false);
        allPieces.add(gPawn);
        Piece a_Pawn = new Pawn(new Place(7,'a'), '♟', Color.BLACK,true,false);
        allPieces.add(a_Pawn);
        Piece b_Pawn = new Pawn(new Place(7,'b'), '♟', Color.BLACK,true,false);
        allPieces.add(b_Pawn);
        Piece c_Pawn = new Pawn(new Place(7,'c'), '♟', Color.BLACK,true,false);
        allPieces.add(c_Pawn);
        Piece d_Pawn = new Pawn(new Place(7,'d'), '♟', Color.BLACK,true,false);
        allPieces.add(d_Pawn);
        Piece e_Pawn = new Pawn(new Place(7,'e'), '♟', Color.BLACK,true,false);
        allPieces.add(e_Pawn);
        Piece f_Pawn = new Pawn(new Place(7,'f'), '♟', Color.BLACK,true,false);
        allPieces.add(f_Pawn);
        Piece g_Pawn = new Pawn(new Place(7,'g'), '♟', Color.BLACK,true,false);
        allPieces.add(g_Pawn);
        Piece h_Pawn = new Pawn(new Place(7,'h'), '♟', Color.BLACK,true,false);
        allPieces.add(h_Pawn);

        //'xYz' is for white and 'x_Yz' is for black
        currentBoard.initializeBoard(
                aPawn, bPawn,
                cPawn, dPawn,
                ePawn, fPawn,
                gPawn, hPawn,
                a_Pawn, b_Pawn,
                c_Pawn, d_Pawn,
                e_Pawn, f_Pawn,
                g_Pawn, h_Pawn);


        matrixFormater(currentBoard.getChessBoard());

        while (currentStateOfTheGame.equals(Status.ACTIVE.toString())) {
            turn();
        }
    }

    public void turn() throws IllegalMoveException {
        String chosedPawn;
        System.out.println("Choose a piece you want to move: ");
        Scanner scanner = new Scanner(System.in);
        chosedPawn = scanner.nextLine();
        String[] chosenPawn = chosedPawn.split("");
        int rowOnWhichThePieceStays = Integer.parseInt(chosenPawn[1]);
        char columnOnWhichThePieceStays = chosenPawn[0].charAt(0);
        Piece piece = (Piece)currentBoard.getSingleObjectFromTheChessBoard(rowOnWhichThePieceStays, currentBoard.columnLetters.indexOf(columnOnWhichThePieceStays));
        switch (chosedPawn.charAt(0)) {
            case ' ' -> {
            }
            default -> {
                piece.move(piece, currentBoard);
            }
        }
        matrixFormater(currentBoard.getChessBoard());
    }

    private void matrixFormater(Object[][] chessBoard) {
        chessBoard = this.currentBoard.getChessBoard();
        for (int i = chessBoard.length - 1; i >= 0; i--) {
            Object[] row = chessBoard[i];
            for (Object element : row) {
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

    public Map<Place, Piece> getCurrentStateOfTheGame() {
        return currentStateOfTheGame;
    }

    public void setCurrentStateOfTheGame(HashMap<Place, Piece> currentStateOfTheGame) {
        this.currentStateOfTheGame = currentStateOfTheGame;
    }
}
