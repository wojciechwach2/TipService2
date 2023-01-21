package com.example.TipService.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Entity // (lombok @Getter @Setter itd czy wygenerować normalnie )

public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "category")
    private List<QuestionEntity> questions = new ArrayList<>();

}
