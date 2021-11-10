package model;

import java.awt.*;

public class Question {
    public enum difficulty {
        EASY, MEDIUM, HARD
    }
    public Point position;
    public difficulty diff;
    public String qBody;
    public ArrayList<Answer> answers;

    public Question(Point position, difficulty diff, String qBody, Answer[] answers) {
        this.position = position;
        this.diff = diff;
        this.qBody = qBody;
        this.answers = answers;
    }

    public Question(int level, String qBody, ArrayList<Answer> answers) {
        this.id++;
        this.level = level;
        this.qBody = qBody;
        this.answers = answers;
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

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "level=" + level +
                ", qBody='" + qBody + '\'' +
                ", answers=" + answers +
                '}';
    }
}
