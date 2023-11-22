package com.learn.quizapp.service;

import com.learn.quizapp.model.Question;
import com.learn.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }


    public List<Question> getQuestionsByDifficultyLevel(String difficultyLevel) {
        return questionRepository.findByDifficultyLevel(difficultyLevel);
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Success!";
    }
}
