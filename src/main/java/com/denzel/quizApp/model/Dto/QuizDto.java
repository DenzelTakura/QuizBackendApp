package com.denzel.quizApp.model.Dto;

import com.denzel.quizApp.model.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
    private long quizId;
    private String tittle,topic;
    private List<Question> questions;


}
