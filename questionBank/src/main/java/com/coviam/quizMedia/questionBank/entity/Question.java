package com.coviam.quizMedia.questionBank.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document
public class Question {

    @Id
    private String queNo;
    @Indexed(unique = true)
    private CompositeKey question;
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

    public Question(String queNo, CompositeKey question, String rightAnswer, String answerType, String difficultyLevel, String questionType, String binaryPath, String category, String isScreened, String isRejected) {
        this.queNo = queNo;
        this.question = question;
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

    public CompositeKey getQuestion() {
        return question;
    }

    public void setQuestion(CompositeKey question) {
        this.question = question;
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
                ", question=" + question +
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