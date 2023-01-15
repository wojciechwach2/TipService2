package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class AnwersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionsEntity question;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;



}
