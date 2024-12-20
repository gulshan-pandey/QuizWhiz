package com.my.quiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.quiz.entity.QuizQuestion;
import com.my.quiz.repo.QuestionRepo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

@Slf4j
@Service
public class QuestionService {


    @Autowired
    QuestionRepo questionRepo;

    @PostConstruct
    public void loadQuizQuestions() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("Backend/src/main/java/com/my/quiz/questions.json");
            List<QuizQuestion> questions = objectMapper.readValue(file, new TypeReference<List<QuizQuestion>>() {});
            // Save the questions into the database
            questionRepo.saveAll(questions);
        } catch (IOException e) {
            log.error(e.getMessage(), e, Level.SEVERE);
        }

    }


    public List<QuizQuestion> getAllQuestions()
    {
        List<QuizQuestion> questionRepoAll = questionRepo.findAll();
        return questionRepoAll;
    }

    public QuizQuestion saveQuestion(QuizQuestion question){
        QuizQuestion save = questionRepo.save(question);
        return save;
    }

    public List<QuizQuestion> saveQuestions(List<QuizQuestion> questions) {
        return questionRepo.saveAll(questions);
    }



}
