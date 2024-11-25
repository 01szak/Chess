package Tests;

import Models.Board;
import Models.Pawn;
import Models.Place;
import enums.Color;
import exceptions.IllegalMoveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    void isCollidingWorkingWithPawnsOnTheSameColumn (){
        Board board = new Board();
        Pawn pawn1 = new Pawn(new Place(4,'e'),'W', Color.WHITE,false,false);
        Pawn pawn2 = new Pawn(new Place(5,'e'),'B',Color.BLACK,false,false);
        board.initializeBoard(
                pawn1,pawn2
        );
    Assertions.assertTrue(pawn1.isColliding(new int []{0,1},board,pawn1));
    Assertions.assertTrue(pawn2.isColliding(new int[]{0,-1},board,pawn2));
    }
    @Test
    void isCollidingWorkingWithPawnsOnDifferentColumn(){
        Board board = new Board();
        Pawn pawn1 = new Pawn(new Place(4,'e'),'W', Color.WHITE,false,false);
        Pawn pawn2 = new Pawn(new Place(5,'d'),'B',Color.BLACK,false,false);
        board.initializeBoard(
                pawn1,pawn2
        );
        Assertions.assertTrue(pawn1.isColliding(new int []{-1,1},board,pawn1));
        Assertions.assertTrue(pawn2.isColliding(new int[]{1,-1},board,pawn2));

    }
    @Test
    void isCaptureWorking(){
        Board board = new Board();
        Pawn pawn1 = new Pawn(new Place(4,'e'),'W', Color.WHITE,false,false);
        Pawn pawn2 = new Pawn(new Place(5,'d'),'B',Color.BLACK,false,false);
    }
//    @Test
//    void canPawnMove2PlacesAfterFirstMove()throws IllegalMoveException {
//        Board board = new Board();
//        Pawn pawn1 = new Pawn(new Place(3,'e'),'W', Color.WHITE,false,false);
//    board.initializeBoard(pawn1);
//        pawn1.move(pawn1,board);
//        Assertions.assertThrows(IllegalMoveException.class,pawn1.move(pawn1,board).)
//
//    }

}