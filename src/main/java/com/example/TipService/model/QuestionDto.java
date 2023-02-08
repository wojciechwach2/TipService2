package com.example.TipService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Component
public class QuestionDto {
    private Long id;
    private Long categoryId;
    private String questionDetails;
    private LocalDate questionDate;
    private String categoryName;
    private AnswerDto answer;

    private List<CommentDto> comments;
}
