package Models;

import java.util.Arrays;
import java.util.List;

public class Board extends Place{


    private final Object[][] chessBoard;
    private Place place;
    private  final int rows;
    private final int columns;


    public static final List<Character> columnLetters = List.of('a','b','c','d','e','f','g','h');

    // TODO:clean it

    public Board() {

        this.rows = 8;
        this.columns = 8;

        this.chessBoard = new Object[rows][columns];

        //for each element it makes a new Place object then sets their index
        for (int row = 0; row < this.chessBoard.length; row++){
            for (int column = 0; column < this.chessBoard[row].length ; column++) {
                this.place = new Place();
                this.chessBoard[row][column] = place;
                place.setRowIndex(row + 1);
                place.setColumnIndex(columnLetters.get(column));
            }
             }
           }
        public Object getSinglePlace(int row, int column){
        //idk why i have to substract 2 insted of 1 :_(
            Object[] rowOfAChessBoard = this.chessBoard[row - 2];
            Place singlePlace = (Place)rowOfAChessBoard[column - 1];
            return singlePlace;
        }

        public void assignPlaceWithPieces(Piece ...args){
            for (int i = 0; i< args.length; i ++) {
                Place place = args[i].getPlace();
                int row = place.getRowIndex();
                int column = columnLetters.indexOf(place.getColumnIndex());
                Object[] chessBoard = this.chessBoard[row];
                chessBoard[column] = args[i];

            }

        }

    @Override
    public String toString() {
//prints rows in desc order
        for (int i = chessBoard.length - 1 ; i >= 0; i--) {
                System.out.println(Arrays.toString(chessBoard[i]));
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
