package com.example.TipService.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String mariola123 = encoder.encode("mariola123");
        System.out.println(mariola123);



    }
}
