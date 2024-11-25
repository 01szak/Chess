package Models;

import enums.Color;
import enums.Status;
import exceptions.IllegalMoveException;

import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece {
    private boolean canEnPassant;

    private boolean isFirstMove;
    private List<int[]> captureArea;

    public Pawn() {
    }

    public Pawn(Place place, char symbol, Color color,Boolean isFirstMove,boolean canEnPassant) {
        this.place = place;
        this.symbol = symbol;
        this.color = color;
        this.isFirstMove = isFirstMove;
        this.canEnPassant = canEnPassant;
    }

    public final List<int[]> allowedMovesForWhite = List.of(new int[]{0, 1}, new int[]{0, 2});
    public final List<int[]> allowedMovesForBlack = List.of(new int[]{0, -1}, new int[]{0, -2});
    public final List<int[]> captureAreaForWhite = List.of(new int[]{1, 1}, new int[]{-1, 1});
    public final List<int[]> captureAreaForBlack = List.of(new int[]{1, -1}, new int[]{-1, -1});


    //TODO
    @Override
    public void move(Piece pawn, Board board) throws IllegalMoveException {
        Game game = new Game();
        game.setStatus(Status.ACTIVE);
        setAllowedMoves((Pawn) pawn);
        setCaptureArea(pawn);
        String[] chosenMove = chooseMove().split("");
        int[] moveVector = new int[2];
        int currentRow = pawn.getPlace().getRowIndex() + 1;
        int currentColumn = board.columnLetters.indexOf(pawn.getPlace().getColumnIndex());
        int yMove = Integer.parseInt(chosenMove[1]) - 1;
        int xMove = board.columnLetters.indexOf(chosenMove[0].charAt(0)) ;
        moveVector[1] = yMove - currentRow;
        moveVector[0] = xMove - currentColumn;
        moveIfLegal(pawn, board, moveVector);
    }

    private void moveIfLegal(Piece pawn, Board board, int[] moveVector) throws IllegalMoveException {
        if (!isColliding(moveVector, board, pawn) && captureArea.contains(moveVector)) {
            throw new IllegalMoveException("Illegal move");
        } else if(isColliding(moveVector, board, pawn) && captureArea.contains(moveVector)){
            board.assignPlaceWithPiece(pawn, moveVector);
            setFirstMove(false);
        }else if(!isColliding(moveVector, board, pawn)) {

            boolean isValidMove = allowedMoves.stream()
                    .anyMatch(moves -> Arrays.equals(moves, moveVector));
            if (!isValidMove) {
                throw new IllegalMoveException("Illegal move");
            } else {
                board.assignPlaceWithPiece(pawn, moveVector);
                isFirstMove = false;

            }
        }
    }


    private void setAllowedMoves(Pawn pawn) {
        if (pawn.getColor().equals(Color.WHITE) && pawn.isFirstMove()) {
            this.allowedMoves = allowedMovesForWhite;
        } else if(pawn.getColor().equals(Color.WHITE) && !pawn.isFirstMove()) {
            this.allowedMoves = allowedMovesForWhite;
            allowedMoves.remove(allowedMoves.get(1));

        } else if (pawn.getColor().equals(Color.BLACK) && pawn.isFirstMove()) {
            this.allowedMoves = allowedMovesForBlack;

        } else if (pawn.getColor().equals(Color.BLACK) && !pawn.isFirstMove()){
            this.allowedMoves = allowedMovesForWhite;
            allowedMoves.remove(allowedMoves.get(1));

        }
    }

    private void setCaptureArea(Piece pawn) {
        if (pawn.getColor().equals(Color.WHITE)) {
            this.captureArea = captureAreaForWhite;
        } else {
            this.captureArea = captureAreaForBlack;
        }
    }

//TODO:dokonczyc i napisac utest

    @Override
    public void capture(int[] moveVector, Board board, Piece pawn) {
        board.assignPlaceWithPiece(pawn, moveVector);
    }




    public boolean isCanEnPassant() {
        return canEnPassant;
    }

    public void setCanEnPassant(boolean canEnPassant) {
        this.canEnPassant = canEnPassant;
    }

    public boolean isFirstMove() {
        return isFirstMove;
    }

    public void setFirstMove(boolean firstMove) {
        isFirstMove = firstMove;
    }

    public List<int[]> getCaptureArea() {
        return captureArea;
    }


}

