package com.denzel.quizApp.service;

import com.denzel.quizApp.model.Question;

import java.util.List;

public interface QuestionService {
    String save(Question question);
    List<Question> fetchByTopic(String topic);
}
