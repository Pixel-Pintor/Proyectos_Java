package cinema.model;

import java.util.Objects;

public class SeatModelPrice extends SeatModel {

    private int price;

    public SeatModelPrice(int row, int column) {
        super(row, column);
        this.price = this.calculateSeatPrice();
    }

    public SeatModelPrice(SeatModel seatModel) {
        super(seatModel.getRow(), seatModel.getColumn());
        this.price = this.calculateSeatPrice();
    }

    public int calculateSeatPrice() {
        if (this.getRow() <= 4)
            return 10;
        else
            return 8;
    }

    public int getPrice() { return price; }

    @Override
    public String toString() {
        return "{" + this.getRow() + ", " + this.getColumn() + ", " + this.getPrice() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SeatModelPrice that = (SeatModelPrice) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}
