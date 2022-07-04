package cinema.model;

import java.util.HashMap;
import java.util.UUID;

public class TokenListModel {

    private final HashMap<String, SeatModel> tokenMap = new HashMap<>();

    public String addToken(SeatModel seatModel) {
        String tokenHash = UUID.randomUUID().toString();
        tokenMap.put(tokenHash, seatModel);
        return tokenHash;
    }

    public SeatModel getSeatByTokenHash(String tokenHash) {
        return tokenMap.get(tokenHash);
    }

    public HashMap<String, SeatModel> getTokenMap() { return tokenMap; }

    public void removeToken(String tokenHash) { tokenMap.remove(tokenHash); }
}
