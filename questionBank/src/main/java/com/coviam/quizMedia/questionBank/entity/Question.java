package com.coviam.quizMedia.questionBank.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Question {

    @Id
    private String  queNo;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String answerType;
    private String difficultyLevel;
    private String questionType;
    private String binaryPath;
    private String category;
    private String isScreened;
    private String isRejected;

    public Question() {
    }

    public Question(String queNo, String question, String option1, String option2, String option3, String option4, String rightAnswer, String answerType, String difficultyLevel, String questionType, String binaryPath, String category) {
        this.queNo = queNo;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.answerType = answerType;
        this.difficultyLevel = difficultyLevel;
        this.questionType = questionType;
        this.binaryPath = binaryPath;
        this.category = category;
    }

    public Question(String queNo, String question, String option1, String option2, String option3, String option4, String rightAnswer, String answerType, String difficultyLevel, String questionType, String binaryPath, String category, String isScreened, String isRejected) {
        this.queNo = queNo;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightAnswer = rightAnswer;
        this.answerType = answerType;
        this.difficultyLevel = difficultyLevel;
        this.questionType = questionType;
        this.binaryPath = binaryPath;
        this.category = category;
        this.isScreened = isScreened;
        this.isRejected = isRejected;
    }

    public String getQueNo() {
        return queNo;
    }

    public void setQueNo(String queNo) {
        this.queNo = queNo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getAnswerType() {
        return answerType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getBinaryPath() {
        return binaryPath;
    }

    public void setBinaryPath(String binaryPath) {
        this.binaryPath = binaryPath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsScreened() {
        return isScreened;
    }

    public void setIsScreened(String isScreened) {
        this.isScreened = isScreened;
    }

    public String getIsRejected() {
        return isRejected;
    }

    public void setIsRejected(String isRejected) {
        this.isRejected = isRejected;
    }


    @Override
    public String toString() {
        return "Question{" +
                "queNo='" + queNo + '\'' +
                ", question='" + question + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", answerType='" + answerType + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", questionType='" + questionType + '\'' +
                ", binaryPath='" + binaryPath + '\'' +
                ", category='" + category + '\'' +
                ", isScreened='" + isScreened + '\'' +
                ", isRejected='" + isRejected + '\'' +
                '}';
    }


}