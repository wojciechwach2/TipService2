package com.example.TipService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(length = 200)
    private String questionSubject;

    @Column(length = 3000)
    private String questionDetails;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate questionDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @OneToOne
    @JoinColumn(name = "id")
    private AnswerEntity answer;
}