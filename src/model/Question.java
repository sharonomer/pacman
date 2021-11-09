package model;

import java.awt.*;
/*
 * defines the question that the user needs to answer after eat the dot.
 * there are 3 level of questions: easy, medium and hard.
 * each question has 4 optional answers: 3 wrong and 1 correct.
 */

public class Question {
    public enum difficulty {
        EASY, MEDIUM, HARD
    }
    public int id;
    public Point position;
    public difficulty diff;
    public String qBody;
    public Answer[] answers;

    public Question(int id, Point position, difficulty diff, String qBody, Answer[] answers) {
        this.id = id;
        this.position = position;
        this.diff = diff;
        this.qBody = qBody;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public difficulty getDiff() {
        return diff;
    }

    public void setDiff(difficulty diff) {
        this.diff = diff;
    }

    public String getqBody() {
        return qBody;
    }

    public void setqBody(String qBody) {
        this.qBody = qBody;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }
}
