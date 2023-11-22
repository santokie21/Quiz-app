package com.learn.quizapp.controller;

import com.learn.quizapp.model.Question;
import com.learn.quizapp.service.QuestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

   @Autowired
   QuestionService questionService;

   @GetMapping("allQuestions")
   public List<Question> getAllQuestions() {
      return questionService.getAllQuestions();
   }

   @GetMapping("category/{category}")
   public List<Question> getQuestionsByCategory(@PathVariable String category) {
      return questionService.getQuestionsByCategory(category);
   }

   @GetMapping("difficultylevel/{difficultyLevel}")
   public List<Question> getQuestionsByDifficultyLevel(@PathVariable String difficultyLevel) {
      return questionService.getQuestionsByDifficultyLevel(difficultyLevel);
   }

   @PostMapping("add")
   public String addQuestion(@RequestBody Question question) {
      return questionService.addQuestion(question);
   }

}
