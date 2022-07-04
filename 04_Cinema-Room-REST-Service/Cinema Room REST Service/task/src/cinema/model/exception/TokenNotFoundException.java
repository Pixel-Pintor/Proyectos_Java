package cinema.model.exception;

public class TokenNotFoundException extends NullPointerException {

    public TokenNotFoundException() {
        super("Wrong token!");
    }
}
