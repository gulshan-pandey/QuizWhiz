package com.my.quiz;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.quiz.entity.QuizQuestion;
import com.my.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class QuizApplication {
    public static void main(String[] args) {
			SpringApplication.run(QuizApplication.class, args);
		}



}
