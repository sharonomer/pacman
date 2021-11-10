package model;

public class Answer {
    public String aBody;
    public boolean isCorrect;

    public Answer(int id, String aBody, boolean isCorrect) {
        this.aBody = aBody;
        this.isCorrect = isCorrect;
    }

    public String getaBody() {
        return aBody;
    }

    public void setaBody(String aBody) {
        this.aBody = aBody;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
