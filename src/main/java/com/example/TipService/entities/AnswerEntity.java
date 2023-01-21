package com.example.TipService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(length = 3000)
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate answerDate;

    @Column
    private Integer rating; // pozytywny i negatywny ?


    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "answer")
    private Set<CommentEntity> comments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity question;



}
