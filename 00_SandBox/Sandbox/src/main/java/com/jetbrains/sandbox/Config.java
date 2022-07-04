package com.jetbrains.sandbox;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SeatArrangement seatArrangement() {
        return new SeatArrangement();
    }

    @Bean
    public Tokens tokens() {
        return new Tokens();
    }
}
