package Models;

import enums.Color;
import exceptions.IllegalMoveException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pawn extends Piece {
    private boolean canEnPassant;

    private boolean isFirstMove;

    public Pawn() {
    }

    public Pawn(Place place, char symbol, Color color) {
        this.place = place;
        this.symbol = symbol;
        this.color = color;
    }

    public final List<int[]> allowedMovesForWhite = List.of(new int[]{0, 1}, new int[]{0, 2});
    public final List<int[]> allowedMovesForBlack = List.of(new int[]{0, -1}, new int[]{0, -2});

    //TODO
    @Override
    public void move(Piece pawn, Board board) throws IllegalMoveException {
        setAllowedMoves(pawn);
        String chosedMove;
        int[] moveVector = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a place on which you want to put selected piece: ");
        chosedMove = scanner.nextLine();
        int currentRow = pawn.getPlace().getRowIndex() + 1;
        int move = Integer.parseInt(chosedMove.split("")[1]);
        moveVector[1] = move - currentRow;
        moveVector[0] = 0;
        boolean isValidMove = allowedMoves.stream()
                .anyMatch(moves -> Arrays.equals(moves, moveVector));
        if (!isValidMove) {
            throw new IllegalMoveException("Illegal move");
        } else {
            board.assignPlaceWithPieces(pawn, moveVector);
        }
    }

    private void setAllowedMoves(Piece pawn) {
        if (pawn.getColor().equals(Color.WHITE)) {
            this.allowedMoves = allowedMovesForWhite;
        } else {
            this.allowedMoves = allowedMovesForBlack;
        }
    }


    @Override
    public Place capture() {
        return null;
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

}
