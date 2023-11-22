package com.learn.quizapp.service;

import com.learn.quizapp.model.Question;
import com.learn.quizapp.model.QuestionWrapper;
import com.learn.quizapp.model.Quiz;
import com.learn.quizapp.repository.QuestionRepository;
import com.learn.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<String> createQuiz(String category, Integer noOfQuestions, String title) {

        List<Question> questions=questionRepository.findRandomQuestionsByCategory(category,noOfQuestions);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questionFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers =new ArrayList<>();

        for(Question q:questionFromDB) {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUsers.add(qw);
        }

        return new ResponseEntity<>(questionsForUsers,HttpStatus.OK);
    }
}
