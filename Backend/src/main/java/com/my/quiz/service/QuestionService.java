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

        String json = """
                [
                    {
                        "id": 1,
                        "questionText": "What is the primary purpose of the 'public' keyword in Java?",
                        "correctAnswer": "To allow access to classes and methods from other packages.",
                        "options": [
                            "To allow access to classes and methods from other packages.",
                            "To restrict access to the class itself.",
                            "To define a method that can be overridden.",
                            "To create a constant variable."
                        ]
                    },
                    {
                        "id": 2,
                        "questionText": "What is the default value of a boolean variable in Java?",
                        "correctAnswer": "false",
                        "options": [
                            "true",
                            "false",
                            "null",
                            "0"
                        ]
                    },
                    {
                        "id": 3,
                        "questionText": "What is the primary purpose of the 'public' keyword in Java?",
                        "correctAnswer": "To allow access to classes and methods from other packages.",
                        "options": [
                            "To allow access to classes and methods from other packages.",
                            "To restrict access to the class itself.",
                            "To define a method that can be overridden.",
                            "To create a constant variable."
                        ]
                    },
                    {
                        "id": 4,
                        "questionText": "What is the default value of a boolean variable in Java?",
                        "correctAnswer": "false",
                        "options": [
                            "true",
                            "false",
                            "null",
                            "0"
                        ]
                    },
                    {
                        "id": 5,
                        "questionText": "Which of the following is a valid variable name in Java?",
                        "correctAnswer": "myVariable",
                        "options": [
                            "1stVariable",
                            "myVariable",
                            "my-variable",
                            "$variable"
                        ]
                    },
                    {
                        "id": 6,
                        "questionText": "Which method is used to start a thread in Java?",
                        "correctAnswer": "start()",
                        "options": [
                            "run()",
                            "execute()",
                            "begin()",
                            "start()"
                        ]
                    },
                    {
                        "id": 7,
                        "questionText": "Which of the following data types is used to represent a single character in Java?",
                        "correctAnswer": "char",
                        "options": [
                            "String",
                            "char",
                            "Character",
                            "int"
                        ]
                    },
                    {
                        "id": 8,
                        "questionText": "What is the size of an int in Java?",
                        "correctAnswer": "4 bytes",
                        "options": [
                            "2 bytes",
                            "4 bytes",
                            "8 bytes",
                            "16 bytes"
                        ]
                    },
                    {
                        "id": 9,
                        "questionText": "Which of the following is a superclass of all classes in Java?",
                        "correctAnswer": "Object",
                        "options": [
                            "Object",
                            "String",
                            "System",
                            "Class"
                        ]
                    },
                    {
                        "id": 10,
                        "questionText": "Which keyword is used to create a constant variable in Java?",
                        "correctAnswer": "final",
                        "options": [
                            "const",
                            "final",
                            "static",
                            "immutable"
                        ]
                    },
                    {
                        "id": 11,
                        "questionText": "What does the 'this' keyword refer to in Java?",
                        "correctAnswer": "The current instance of the class",
                        "options": [
                            "The current instance of the class",
                            "The parent class",
                            "The current method",
                            "The main method"
                        ]
                    },
                    {
                        "id": 12,
                        "questionText": "What does the 'super' keyword refer to in Java?",
                        "correctAnswer": "The superclass of the current object",
                        "options": [
                            "The current object",
                            "The current class",
                            "The superclass of the current object",
                            "The method inside the superclass"
                        ]
                    },
                    {
                        "id": 13,
                        "questionText": "Which of the following is a correct syntax to create an array in Java?",
                        "correctAnswer": "int[] arr = new int[5];",
                        "options": [
                            "int arr[] = new int[5];",
                            "int arr = new int[5];",
                            "int[] arr = new int[5];",
                            "int[] arr = [5];"
                        ]
                    },
                    {
                        "id": 14,
                        "questionText": "Which of the following interfaces does a class need to implement to be able to create a thread in Java?",
                        "correctAnswer": "Runnable",
                        "options": [
                            "Runnable",
                            "Threadable",
                            "Callable",
                            "Thread"
                        ]
                    },
                    {
                        "id": 15,
                        "questionText": "What is the default value of a reference variable in Java?",
                        "correctAnswer": "null",
                        "options": [
                            "null",
                            "0",
                            "undefined",
                            "empty"
                        ]
                    },
                    {
                        "id": 16,
                        "questionText": "Which exception is thrown when an attempt to divide by zero occurs in Java?",
                        "correctAnswer": "ArithmeticException",
                        "options": [
                            "NullPointerException",
                            "ArithmeticException",
                            "IndexOutOfBoundsException",
                            "IOException"
                        ]
                    },
                    {
                        "id": 17,
                        "questionText": "Which of the following is used to handle exceptions in Java?",
                        "correctAnswer": "try-catch block",
                        "options": [
                            "if-else block",
                            "try-catch block",
                            "switch-case block",
                            "for-each block"
                        ]
                    }
                ]
                """;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<QuizQuestion> questions = objectMapper.readValue(json, new TypeReference<List<QuizQuestion>>() {});
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
