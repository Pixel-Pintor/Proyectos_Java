package cinema.model;

import java.util.Objects;

public class SeatModel {
    private int row;
    private int column;

    public SeatModel(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public SeatModel() {}

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }


    @Override
    public String toString() {
        return "{" + this.getRow() + ", " + this.getColumn() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatModel seatModel = (SeatModel) o;
        return row == seatModel.row && column == seatModel.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
