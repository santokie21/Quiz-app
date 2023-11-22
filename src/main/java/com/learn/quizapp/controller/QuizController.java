package com.learn.quizapp.controller;

import com.learn.quizapp.model.Question;
import com.learn.quizapp.model.QuestionWrapper;
import com.learn.quizapp.service.QuizService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
     QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam  String category,@RequestParam Integer noOfQuestions,@RequestParam String title){
        return quizService.createQuiz(category,noOfQuestions,title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){
        return quizService.getQuestions(id);
    }
}
