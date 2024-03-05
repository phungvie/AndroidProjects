package com.example.sonic.network.model;

public class LoginRequest {
    String username;
    String password;

    public LoginRequest() {
        this.username = "viet@gmail.com";
        this.password = "123";
    }
    public LoginRequest(String username,String password) {
        this.username = username;
        this.password = password;
    }
}
