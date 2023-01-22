package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Getter
@Setter
@Component
public class QuestionDto {
    private Long categoryId;
    private String questionSubject;
    private String questionDetails;
    private LocalDate questionDate;
    private String categoryName;
}
