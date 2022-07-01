package cinema.model.exception;

public class CustomExceptionMessage {

    String error;

    public CustomExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
