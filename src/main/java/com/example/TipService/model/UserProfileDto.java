package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter
public class UserProfileDto {

    private Long id;
    private String name;
    private String surname;
    private String nickname;
    private String email;
}
