package cinema.controller;

import cinema.model.SeatModel;
import cinema.model.TokenModel;
import cinema.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class TokenController {

    TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/return")
    public Map<String, SeatModel> returnToken(@RequestBody Map<String, String> jsonToken) {
        return tokenService.manageReturnTokenRequest(jsonToken);
    }

    @GetMapping("/get_all_tokens")
    public Map<String, SeatModel> getAllTokens() {
        return tokenService.getTokenMap();
    }
}
