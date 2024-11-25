package Models;


public class Place implements Comparable<Place>{
    private int rowIndex;
    private char columnIndex;


    public Place() {
    }

    public Place(int rowIndex, char columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;

    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public char getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(char columnIndex) {
        this.columnIndex = columnIndex;
    }

    @Override
    public String toString() {
        return columnIndex + Integer.toString(rowIndex + 1);
    }
//    public String toString(Piece piece){
//    char pieceSymbol = piece.getSymbol();
//    return Character.toString(pieceSymbol);
//    }

    @Override
    public int compareTo(Place o) {
        return 0;
    }
}


