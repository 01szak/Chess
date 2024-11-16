package Models;

import enums.Color;
import exceptions.BoardCreatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {


    private Place[][] place;
    private  int rows;
    private  int columns ;

    public static final List<Character> columnLetters = List.of('a','b','c','d','e','f','g','h');

    public Board() {
    }
    //ill clean it up a bit in next commit
    public Board(int rows, int columns) throws BoardCreatorException{
        this.rows = rows;
        this.columns = columns;
        if(rows != 8 || columns != 8){
            throw new BoardCreatorException("Error occurred while creating a board: Wrong dimensions");
        }else {
        this.place = new Place[rows][columns ];
        }
        //for each element it makes a new Place object then sets their index
        for (int row = 0; row < this.place.length; row++){
            for (int column = 0; column < this.place[row].length ; column++) {
                this.place[row][column] = new Place();
                this.place[row][column].setRowIndex(row + 1);
                this.place[row][column].setColumnIndex(columnLetters.get(column));
            }
             }

        }

    @Override
    public String toString() {
//prints rows in desc order
        for (int i = place.length - 1 ; i >= 0; i--) {
                System.out.println(Arrays.toString(place[i]));
        }
        return "";
    }
}
