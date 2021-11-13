package model;

import java.sql.Date;

public class Highscore{

    public Integer score;
    public String username;
    public java.sql.Date date;

    public Highscore(int score, String username, Date date) {
        this.score = score;
        this.username = username;
        this.date = date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Highscore{" +
                "score=" + score +
                ", username='" + username + '\'' +
                ", date=" + date +
                '}';
    }
}
