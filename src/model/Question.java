package model;

import java.awt.*;
import java.util.ArrayList;
/*
 * defines the question that the user needs to answer after eat the dot.
 * there are 3 level of questions: easy, medium and hard.
 * each question has 4 optional answers: 3 wrong and 1 correct.
 */

public class Question {

    public Point position;
    public int diff;
    public String qBody;
    public ArrayList<Answer> answers;

    public Question(Point position, int diff, String qBody, ArrayList<Answer> answers) {
        this.position = position;
        this.diff = diff;
        this.qBody = qBody;
        this.answers = answers;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getDiff() {
        return diff;
    }

    public void setDiff(int diff) {
        this.diff = diff;
    }

    public String getqBody() {
        return qBody;
    }

    public void setqBody(String qBody) {
        this.qBody = qBody;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "position=" + position +
                ", diff=" + diff +
                ", qBody='" + qBody + '\'' +
                ", answers=" + answers +
                '}';
    }
}