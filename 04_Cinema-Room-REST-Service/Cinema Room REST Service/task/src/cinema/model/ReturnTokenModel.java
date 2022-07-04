package cinema.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ReturnTokenModel {

    private final String tokenHash;
    @Autowired
    private TokenListModel tokenListModel;

    public ReturnTokenModel(Map<String, String> tokenJson) {
        this.tokenHash = tokenJson.get("token");
    }

    public SeatModel getSeatByTokenHash() {
        return tokenListModel.getSeatByTokenHash(tokenHash);
    }
}
