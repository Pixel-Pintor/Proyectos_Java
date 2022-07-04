package com.jetbrains.sandbox;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class ReturnToken {
    private String token;
    @Autowired
    private Tokens tokens;

    public ReturnToken(Map<String, String> json) {
        this.token = json.get("token");
    }

    public Seat getSeatByToken() {
        return tokens.getSeatByToken(token);
    }
}