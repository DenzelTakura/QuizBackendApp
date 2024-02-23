package com.denzel.quizApp.controller;

import com.denzel.quizApp.model.Dto.QuizDto;
import com.denzel.quizApp.model.QuizTest;
import com.denzel.quizApp.service.QuizTestService;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@RequestMapping("api/quiz")
public class QuizTestController {
    private final QuizTestService quizTestService;

    @GetMapping("/{id}")
    public QuizTest fetchById(@PathVariable Long id) {
        return quizTestService.fetchById(id);
    }
    @GetMapping("/{title}")
    public List<QuizTest> fetchByTittle(@PathVariable String title) {
        return quizTestService.fetchByTittle(title);
    }

  @GetMapping("/{topic}")
    public List<QuizTest> fetchByTopic(@PathVariable String topic) {
        return quizTestService.fetchByTopic(topic);
    }

    @GetMapping("/generate/{topic},{numberOfQuestions},{title}")
    public String generateQuiz(@PathVariable String topic,
                               @PathVariable Long numberOfQuestions,
                               @PathVariable String title){
        return quizTestService.generateQuiz(topic,numberOfQuestions,title);
    }

    @GetMapping("/fetch/{quizId}")
    public QuizDto fetchQuiz(@PathVariable Long quizId){
        return quizTestService.fetchTest(quizId);
    }

}