package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Getter
@Setter
@Component
public class PasswordDto {
    private String currentPassword;
    private String newPassword;
    private String reenteredNewPassword;
}
