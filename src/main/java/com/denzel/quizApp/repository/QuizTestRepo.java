package com.denzel.quizApp.repository;

import com.denzel.quizApp.model.QuizTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizTestRepo extends CrudRepository <QuizTest,Long> {
    QuizTest getById(Long id);
    List<QuizTest> getQuizTestsByTopic(String topic);
    List<QuizTest> getQuizTestsByTittle(String tittle);
}
