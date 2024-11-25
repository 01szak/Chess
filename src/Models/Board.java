package Models;

import java.util.Arrays;
import java.util.List;

public class Board {


    private final Object[][] chessBoard;
    private Place place;
    private final int rows;
    private final int columns;

    public final List<Character> columnLetters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h');


    // TODO:clean it
    public Board() {

        this.rows = 8;
        this.columns = 8;

        this.chessBoard = new Object[rows][columns];

        //for each element it makes a new Place object then sets their index
        for (int row = 0; row < this.chessBoard.length; row++) {
            for (int column = 0; column < this.chessBoard[row].length; column++) {
                this.place = new Place();
                this.chessBoard[row][column] = place;
                place.setRowIndex(row);
                place.setColumnIndex(columnLetters.get(column));
            }
        }
    }



    public Place getSinglePlace(int row, int column) {
        //idk why i have to substract 2 insted of 1 :_(
        Object[] rowOfAChessBoard = this.chessBoard[row - 2];
        Place singlePlace = (Place) rowOfAChessBoard[column - 1];
        return singlePlace;
    }

    public Piece getSinglePiece(int row, int column) {

        Object[] rowOfAChessBoard = this.chessBoard[row - 1];
        Piece singlePiece = (Piece) rowOfAChessBoard[column - 1];
        return singlePiece;
    }

    //initialization method
    //I have written sth that fixes the mistakes of overriding the -1 row place after the piece, but it is not a prevention as same as the method below
    public void initializeBoard(Piece... args) {
        for (int i = 0; i < args.length; i++) {
            Object[][] chessBoard = this.chessBoard;
            Piece piece = args[i];
            Place place = piece.getPlace();
            int row = place.getRowIndex() + 1;
            int column = columnLetters.indexOf(place.getColumnIndex());
            Place placeBehindPiece = piece.setPlace(place, row - 1, place.getColumnIndex());
            chessBoard[row][column] = placeBehindPiece;
            chessBoard[row][column] = piece;

        }

    }

    public void assignPlaceWithPiece(Piece piece, int[] moveVector) {
        Place oldPlace = piece.setPlace(new Place(),piece.getPlace().getRowIndex() + 1,piece.getPlace().getColumnIndex());
        char oldColumnIndex = oldPlace.getColumnIndex();
        int oldRow = oldPlace.getRowIndex();

        chessBoard[oldRow][columnLetters.indexOf(oldPlace.getColumnIndex())] = oldPlace;

        int newRow = moveVector[1] + oldRow ;
        int column = moveVector[0] + columnLetters.indexOf(oldColumnIndex);



        chessBoard[newRow][column] = piece;
        piece.setPlace(new Place(),newRow - 1,columnLetters.get(column));


    }


    @Override
    public String toString() {
        for (int row = chessBoard.length - 1; row >= 0; row--) {
            System.out.println(Arrays.toString(chessBoard[row]));
        }
        return "";
    }

    public Object[][] getChessBoard() {
        return chessBoard;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
