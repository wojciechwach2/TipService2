package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@Component
public class CommentDto {

    private Long id;
    private String commentContent;
    private LocalDate commentDate;


}
