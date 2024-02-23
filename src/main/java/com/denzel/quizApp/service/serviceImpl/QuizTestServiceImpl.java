package com.denzel.quizApp.service.serviceImpl;

import com.denzel.quizApp.model.Dto.QuizDto;
import com.denzel.quizApp.model.Question;
import com.denzel.quizApp.model.QuizTest;
import com.denzel.quizApp.repository.QuestionRepo;
import com.denzel.quizApp.repository.QuizTestRepo;
import com.denzel.quizApp.service.QuizTestService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Data
@Service
public class QuizTestServiceImpl implements QuizTestService {
    private final QuizTestRepo quizTestRepo;
    private final QuestionRepo questionRepo;

    @Override
    public QuizTest fetchById(Long id) {
        return quizTestRepo.getById(id);
    }

    @Override
    public String save(QuizTest quizTest) {
        quizTestRepo.save(quizTest);
        return "successful";
    }

    @Override
    public List<QuizTest> fetchByTittle(String tittle) {
        return quizTestRepo.getQuizTestsByTittle(tittle);
    }

    @Override
    public List<QuizTest> fetchByTopic(String topic) {
        return quizTestRepo.getQuizTestsByTopic(topic);
    }


    public String generateQuiz(String topic, Long numberOfQuestions,String title) {
        QuizTest quizTest= new QuizTest();
        quizTest.setTittle(title);
        quizTest.setTopic(topic);
        quizTest.setNumberOfQuestions(numberOfQuestions);
        quizTest.setQuestionList(getQuestions(topic,numberOfQuestions));
        quizTestRepo.save(quizTest);
        return ("Quiz generated fetch by id :" + quizTest.getId());
    }

    public List<Question> getQuestions(String topic,Long numOfQuestions){
        int counter =0;
        List<Question> questionList = questionRepo.getQuestionsByTopic(topic);
        List<Question> processedList= null;
        for(Question q:questionList){
            Random random =new Random(questionList.toArray().length);
           int pointer =random.nextInt();
           processedList.add(questionList.get(pointer));
           questionList.remove(pointer);
           counter+=1;
           if(counter >= numOfQuestions || questionList.toArray().length == 0){
               break;
           }
        }
        return processedList;
    }

    @Override
    public QuizDto fetchTest(Long quizId){
        QuizTest quiz = quizTestRepo.getById(quizId);
        QuizDto quizDto = new QuizDto();

        quizDto.setQuizId(quiz.getId());
        quizDto.setTittle(quiz.getTittle());
        quizDto.setTopic(quiz.getTopic());
        quizDto.setQuestions(quiz.getQuestionList());

        return quizDto;
    }

}
