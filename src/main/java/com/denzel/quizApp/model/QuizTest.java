package com.denzel.quizApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class QuizTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tittle,topic;
    private Float mark;
    private Long numberOfQuestions;
    @OneToMany
    private List<Question> questionList;
}
