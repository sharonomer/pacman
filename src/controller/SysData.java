package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Answer;
import model.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SysData {
    // parsing file "JSONExample.json"

    private static SysData sysData = null;
    private static ArrayList<Question> qa;
    
    public static SysData getInstance()
    {
        if (sysData == null)
            sysData = new SysData();
        return sysData;
    }


    public void readJSON() {

        JSONParser parser = new JSONParser();

        try {
            Reader reader = new FileReader("src\\resources\\QuestionsFormat.json");

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            JSONArray questionsAndAnswers = (JSONArray) jsonObject.get("questions");
            System.out.println(questionsAndAnswers);

            questionsAndAnswers.forEach( QAndAs -> parseQuestion( (JSONObject) QAndAs) );


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseQuestion(JSONObject qAndAs)
    {
        //Handle Answers Data
        //Get correct answer position
        String correct_ans = (String) qAndAs.get("correct_ans");

        JSONArray answers = (JSONArray) qAndAs.get("answers");
        System.out.println(answers);
        int i = 0;
        ArrayList<Answer> a = new ArrayList<Answer>();
        for (i = 0; i<answers.size(); i++){
            a.add(new Answer((String)answers.get(i), i == new Integer(correct_ans) - 1));
        }
        System.out.println(a);

        //Handle Question Data
        //Get questionId object within list
        String questionId = (String) qAndAs.get("question");

        //Get question level
        String level = (String) qAndAs.get("level");

        //Get question team
        String team = (String) qAndAs.get("team");

        Question q = new Question(new Integer(level), questionId, a);

        System.out.println(q);
    }
}












