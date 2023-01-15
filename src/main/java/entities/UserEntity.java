package entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;




    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<AnwersEntity> answers;


}