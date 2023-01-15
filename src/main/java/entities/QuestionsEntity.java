package entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class QuestionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3000)
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Long getId;

    private String title;
    private String getContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "QuestionsEntity", cascade = CascadeType.ALL)
    private List<AnwersEntity> answers;

    @OneToMany(mappedBy = "QuestiosEntity", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;



}
