package cinema.service;

import cinema.model.SeatModel;
import cinema.model.TokenListModel;
import cinema.model.TokenModel;
import cinema.model.exception.TokenNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TokenService {

    RoomService roomService;
    TokenListModel tokenListModel;

    public Map<String, SeatModel> manageReturnTokenRequest(Map<String, String> jsonToken) {
        try {
            SeatModel seatModel = tokenListModel.getSeatByTokenHash(jsonToken.get("token"));
            seatModel.seatAvailable(true);
            tokenListModel.removeToken(jsonToken.get("token"));
            return Map.of("returned_ticket", seatModel);
        } catch (Exception e) {
            throw new TokenNotFoundException();
        }
    }

    public Map<String, SeatModel> getTokenMap() {
        return tokenListModel.getTokenMap();
    }
}
