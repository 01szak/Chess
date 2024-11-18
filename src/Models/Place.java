package Models;


public class Place{
    private int rowIndex;
    private char columnIndex;

    public Place() {
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
        return columnIndex + Integer.toString(rowIndex);
    }
    public String toString(Piece piece){
    char pieceSymbol = piece.getSymbol();
    return Character.toString(pieceSymbol);
    }
}


