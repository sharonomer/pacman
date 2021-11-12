package controller;

import java.awt.*;
import java.io.*;
import java.util.*;

import model.Answer;
import model.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 */
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

        parser.reset();

        try {
            Reader reader = new FileReader("src\\resources\\Highscores.json");

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            System.out.println(jsonObject);

            JSONArray highscores = (JSONArray) jsonObject.get("highscores");
            System.out.println(highscores);

            //highscores.forEach( highscore -> parseHighscore( (JSONObject) highscore) );

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        writeQuestion(new Question(-1, -1,100, "abc", new ArrayList<Answer>(Arrays.asList(new Answer("cacac", false), new Answer("#$%#$%$%$", false)))));
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
            a.add(new Answer((String)answers.get(i), i == Integer.parseInt(correct_ans) - 1));
        }
        System.out.println(a);

        //Handle Question Data
        //Get questionId object within list
        String questionId = (String) qAndAs.get("question");

        //Get question level
        String level = (String) qAndAs.get("level");

        //Get question team
        String team = (String) qAndAs.get("team");

        Question q = new Question(-1, -1, Integer.parseInt(level), questionId, a);

        System.out.println(q);
    }

    private static void writeQuestion(Question question){
        JSONObject questionDetails = new JSONObject();
        questionDetails.put("question", question.getqBody());
        questionDetails.put("answers", question.getAnswers());

        JSONObject questionObject = new JSONObject();
        questionObject.put("questions", questionDetails);


        try {
            FileWriter file = new FileWriter("test.json");
            file.append(questionObject.toJSONString());
            file.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void updateQuestion(JSONObject qAndAs){

    }
}












