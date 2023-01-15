package entities;



import javax.persistence.*;
import java.util.List;

@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<QuestionsEntity> questions;



}
