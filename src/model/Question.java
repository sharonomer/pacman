package model;

import java.awt.*;
import java.util.ArrayList;
/*
 * defines the question that the user needs to answer after eat the dot.
 * there are 3 level of questions: easy, medium and hard.
 * each question has 4 optional answers: 3 wrong and 1 correct.
 */

public class Question extends Food{

    public int diff;
    public String qBody;
    public ArrayList<Answer> answers;
    public static int id = 0;

    public Question(int x, int y, int diff, String qBody, ArrayList<Answer> answers) {
        super(x, y);
        this.diff = diff;
        this.qBody = qBody;
        this.answers = answers;
        id++;
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