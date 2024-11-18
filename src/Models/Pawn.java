package Models;

import enums.Color;
import exceptions.IllegalMoveException;

import java.util.List;

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

    @Override
    public Place move(Pawn pawn, int row, char column) throws IllegalMoveException {
        List<int[]> possibleMoves = addAllowedMoves();
        Place oldPlace = pawn.getPlace();
        int[] moveVector = new int[]{row,column};
        Place newPlace = pawn.setPlace(place, row, column);


        if(!possibleMoves.contains(moveVector)){
            throw new IllegalMoveException("Illegal move");
        }
//        for (int i = 0; i < possibleMoves.size(); i++) {
//            int[] temp = possibleMoves.get(i);
//            if (oldPlace.getRowIndex() - newPlace.getRowIndex() == temp[0] && oldPlace.getColumnIndex() - newPlace.getColumnIndex() == temp[1]) {
//            } else throw new IllegalMoveException("Illegal move");
//        }

        return newPlace;
    }

    public List<int[]> addAllowedMoves() {
        if (color.equals(Color.WHITE)) {
            allowedMoves.add(new int[]{0, 1});
            if (isFirstMove) {
                allowedMoves.add(new int[]{0, 2});
            } else {
                allowedMoves.add(new int[]{0, -1});
                if (isFirstMove) {
                    allowedMoves.add(new int[]{0, -2});

                }
            }

        }
        return allowedMoves;
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
