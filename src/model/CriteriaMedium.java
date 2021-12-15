package model;

import java.util.ArrayList;

public class CriteriaMedium implements Criteria {
    @Override
    public ArrayList<Question> meetCriteria(ArrayList<Question> questions) {
        ArrayList<Question> mediumQuestions = new ArrayList<Question>();
        for (Question q : questions) {
            if (q.getDiff() == 2) {
                mediumQuestions.add(q);
            }
        }
        return mediumQuestions;
    }
}
