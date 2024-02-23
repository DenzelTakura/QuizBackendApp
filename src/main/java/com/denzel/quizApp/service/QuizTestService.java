package com.denzel.quizApp.service;

import com.denzel.quizApp.model.Dto.QuizDto;
import com.denzel.quizApp.model.QuizTest;

import java.util.List;

public interface QuizTestService {
    QuizTest fetchById(Long id);
    String save(QuizTest quizTest);
    List<QuizTest> fetchByTittle(String tittle);
    List<QuizTest> fetchByTopic(String topic);

    QuizDto fetchTest(Long quizId);
    String generateQuiz(String topic, Long numberOfQuestions, String title);
}
