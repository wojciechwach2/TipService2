package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class UserDto {

    private String name;
    private String surname;
    private String nickname;
    private String email;
    private String password;


}
