package com.denzel.quizApp.service.serviceImpl;

import com.denzel.quizApp.model.Question;
import com.denzel.quizApp.repository.QuestionRepo;
import com.denzel.quizApp.service.QuestionService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    @Override
    public String save(Question question) {
        questionRepo.save(question);
        return "successful";
    }

    @Override
    public List<Question> fetchByTopic(String topic) {
        return questionRepo.getQuestionsByTopic(topic);
    }
}
