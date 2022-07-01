package cinema.model.exception;

public class SeatBookedException extends RuntimeException {

    public SeatBookedException() {
        super("The ticket has been already purchased!");
    }
}
