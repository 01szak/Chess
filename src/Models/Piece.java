package Models;

import enums.Color;
import exceptions.IllegalMoveException;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class Piece {

    protected String name;
    protected char symbol;
    protected Place place;

    protected Color color;
    protected List<int[]> allowedMoves;

    public abstract Place capture();

    public abstract Place move(Pawn pawn,int row,char column)throws IllegalMoveException;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<int[]> getAllowedMoves() {
        return allowedMoves;
    }

    public void setAllowedMoves(List<int[]> allowedMoves) {
        this.allowedMoves = allowedMoves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Place getPlace() {
        return place;
    }

    public Place setPlace(Place place,int row,char column) {
        place.setRowIndex(row);
        place.setColumnIndex(column);
        this.place = place;
        return place;
    }


    @Override
    public String toString() {
        return Character.toString(symbol);
    }
}