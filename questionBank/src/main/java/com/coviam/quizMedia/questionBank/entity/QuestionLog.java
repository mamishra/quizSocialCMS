package com.coviam.quizMedia.questionBank.entity;

public class QuestionLog {
    private String fileName;
    private int totalQuestions;
    private int questionsAccepted;
    private int duplicateQuestions;

    public QuestionLog() {
    }

    public QuestionLog(String fileName, int totalQuestions, int questionsAccepted, int duplicateQuestions) {
        this.fileName = fileName;
        this.totalQuestions = totalQuestions;
        this.questionsAccepted = questionsAccepted;
        this.duplicateQuestions = duplicateQuestions;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getQuestionsAccepted() {
        return questionsAccepted;
    }

    public void setQuestionsAccepted(int questionsAccepted) {
        this.questionsAccepted = questionsAccepted;
    }

    public int getDuplicateQuestions() {
        return duplicateQuestions;
    }

    public void setDuplicateQuestions(int duplicateQuestions) {
        this.duplicateQuestions = duplicateQuestions;
    }

    @Override
    public String toString() {
        return "QuestionLog{" +
                "fileName='" + fileName + '\'' +
                ", totalQuestions=" + totalQuestions +
                ", questionsAccepted=" + questionsAccepted +
                ", duplicateQuestions=" + duplicateQuestions +
                '}';
    }
}


