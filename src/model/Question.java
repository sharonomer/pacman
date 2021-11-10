package model;

import java.awt.*;
import java.util.ArrayList;

public class Question {
    public enum difficulty {
        EASY(1), MEDIUM(2), HARD(3);
        private int indicator;
        difficulty(int indicator) {
            this.indicator = indicator;
        }
    }
    public static int id = 0;
    public Point position;
    public difficulty diff;
    public int level;
    public String qBody;
    public ArrayList<Answer> answers;

    public Question(int id, Point position, difficulty diff, String qBody, ArrayList<Answer> answers) {
        this.id = id;
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
