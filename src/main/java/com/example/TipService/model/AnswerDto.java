package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Getter
@Setter
public class AnswerDto {

    private long id;
    private String description;
    private LocalDate answerDate;
    private Integer rating;

}
