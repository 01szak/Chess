package Tests;

import Models.Board;
import Models.Pawn;
import enums.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    void isCollidingWorkingWithPawnsOnTheSameColumn (){
        Board board = new Board();
        Pawn pawn1 = new Pawn(board.getSinglePlace(3,5),'W', Color.WHITE);
        Pawn pawn2 = new Pawn(board.getSinglePlace(4,5),'B',Color.BLACK);
        board.initializeBoard(
                pawn1,pawn2
        );
    Assertions.assertTrue(pawn1.isColliding(new int []{0,1},board,pawn1));
    Assertions.assertTrue(pawn2.isColliding(new int[]{0,-1},board,pawn2));
    }
    @Test
    void isCollidingWorkingWithPawnsOnDifferentColumn(){
        Board board = new Board();
        Pawn pawn1 = new Pawn(board.getSinglePlace(4,5),'W', Color.WHITE);
        Pawn pawn2 = new Pawn(board.getSinglePlace(5,4),'B',Color.BLACK);
        board.initializeBoard(
                pawn1,pawn2
        );
        Assertions.assertTrue(pawn1.isColliding(new int []{-1,1},board,pawn1));
        Assertions.assertTrue(pawn2.isColliding(new int[]{1,-1},board,pawn2));

    }
//    @Test
//    void isCaptureWorking(){
//        Board board = new Board();
//        Pawn pawn1 = new Pawn(board.getSinglePlace(4,5),'W', Color.WHITE);
//        Pawn pawn2 = new Pawn(board.getSinglePlace(5,4),'B',Color.BLACK);
//        Assertions.assertEquals(board.getSinglePlace(5,4).,);
//    }

}