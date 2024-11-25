package Tests;

import Models.Board;
import Models.Pawn;
import Models.Place;
import enums.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    @Test
    void isGetSinglePlaceReturnsPieces(){
        Board board = new Board();
        Pawn pawn1 = new Pawn(new Place(4,'e'),'W', Color.WHITE,false,false);
        board.initializeBoard(pawn1);
        Object o = board.getSingleObjectFromTheChessBoard(4,4).getClass();
        Assertions.assertEquals(pawn1.getClass(),o);
    }
}
