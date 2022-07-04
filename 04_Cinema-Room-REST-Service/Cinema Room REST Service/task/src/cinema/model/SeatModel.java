package cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class SeatModel {

    private int row;
    private int column;
    private int price;
    private boolean available;

    public SeatModel(int row, int column, boolean available) {
        this.row = row;
        this.column = column;
        this.price = this.calculateSeatPrice();
        this.available = available;
    }

    public SeatModel() {}

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() { return price; }

    public void seatAvailable(boolean available) {
        this.available = available;
    }

    public int calculateSeatPrice() {
        return this.row <= 4 ? 10 : 8;
    }


    @Override
    public String toString() {
        return "{" +
                "row=" + row +
                ", column=" + column +
                ", price=" + price +
                '}';
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
