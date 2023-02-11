package quizzApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;

    @OneToOne
    private Answer correctResponse;

    @ManyToMany
    private List<Answer> choices;

    @ManyToMany
    private List<Game> games;
}
