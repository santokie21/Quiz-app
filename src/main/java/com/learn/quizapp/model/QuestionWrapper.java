package com.learn.quizapp.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String category;
    private String questionTitle;

    public QuestionWrapper(Integer id, String category, String questionTitle, String option1, String option2, String option3) {
        this.id = id;
        this.category = category;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
