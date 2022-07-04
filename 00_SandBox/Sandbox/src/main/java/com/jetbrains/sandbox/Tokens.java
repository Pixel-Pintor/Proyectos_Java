package com.jetbrains.sandbox;

import java.util.HashMap;
import java.util.UUID;

// TokenModel.java
public class Tokens {
    private HashMap<String, Seat> tokenMap = new HashMap<>();

    public String addToken(Seat seat) {
        String uuid = UUID.randomUUID().toString();
        tokenMap.put(uuid, seat);
        return uuid;
    }

    public Seat getSeatByToken(String token) {
        return tokenMap.get(token);
    }

    public HashMap<String, Seat> getTokenMap() {
        return tokenMap;
    }

    public void removeToken(String token) {
        tokenMap.remove(token);
    }

}
