package entities;

import javax.persistence.*;

@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private AnwersEntity answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionsEntity question;

    // Getters, setters, and constructors

}
