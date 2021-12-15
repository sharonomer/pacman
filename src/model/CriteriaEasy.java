package model;

import java.util.ArrayList;

public class CriteriaEasy implements Criteria {
    @Override
    public ArrayList<Question> meetCriteria(ArrayList<Question> questions) {
        ArrayList<Question> easyQuestions = new ArrayList<Question>();
        for (Question q : questions) {
            if (q.getDiff() == 1) {
                easyQuestions.add(q);
            }
        }
        return easyQuestions;
    }
}
