package com.denzel.quizApp.repository;

import com.denzel.quizApp.model.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question,Long> {

    List<Question> getQuestionsByTopic(String Topic);
}
