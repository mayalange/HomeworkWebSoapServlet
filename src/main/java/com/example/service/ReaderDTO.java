package com.example.service;

import lombok.Data;

@Data
public class ReaderDTO {
    String name;
    String email;
    String phone;

    public ReaderDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ReaderDTO(){};
}
