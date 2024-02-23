package com.denzel.quizApp.controller;

import com.denzel.quizApp.model.Question;
import com.denzel.quizApp.service.QuestionService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("api/questions")
public class QuestionController {

    private final QuestionService questionService;

  @PostMapping("/add")
    public String save(@RequestBody Question question) {
        questionService.save(question);
        return "successful";
    }
}
