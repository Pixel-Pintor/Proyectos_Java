package cinema.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenModel {

    private final Map<String, SeatModel> token = new HashMap<>();
    private String tokenHash;
    private SeatModel tokenSeat;

    public TokenModel(SeatModel seatModel) {
        this.tokenHash = UUID.randomUUID().toString();
        this.tokenSeat = seatModel;
        createToken();
    }

    public TokenModel() {}

    private void createToken() {
        token.put(tokenHash, tokenSeat);
    }

    public String getTokenHash() {
        return tokenHash;
    }

    public SeatModel getTokenSeat() {
        return tokenSeat;
    }
}
