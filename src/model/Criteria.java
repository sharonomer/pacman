package model;

import java.util.ArrayList;

public interface Criteria {
    public ArrayList<Question> meetCriteria(ArrayList<Question> questions);
}
