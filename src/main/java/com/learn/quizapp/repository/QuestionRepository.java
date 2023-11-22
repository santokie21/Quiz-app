package com.learn.quizapp.repository;

import com.learn.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);
    List<Question> findByDifficultyLevel(String difficultyLevel);

    @Query(value = "select * from question as q where q.category=:category   limit :noOfQuestions",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, Integer noOfQuestions);
}
