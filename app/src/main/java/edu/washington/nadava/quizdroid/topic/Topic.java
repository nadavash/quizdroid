package edu.washington.nadava.quizdroid.topic;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadavash on 5/7/15.
 */
public class Topic {
    private String title;
    private Drawable icon;
    private String description;
    private String longDescription;
    private List<Question> questions;

    public static Topic fromJson(JSONObject jsonTopic) throws JSONException {
        Topic topic = new Topic();
        topic.setTitle(jsonTopic.getString("title"));
        topic.setDescription(jsonTopic.getString("desc"));

        JSONArray jsonQuestions = jsonTopic.getJSONArray("questions");
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < jsonQuestions.length(); ++i) {
            questions.add(Question.fromJson(jsonQuestions.getJSONObject(i)));
        }
        topic.setQuestions(questions);

        return topic;
    }

    public Topic() {

    }

    public Topic(String title, String description, String longDescription,
                 List<Question> questions) {
        this.title = title;
        this.description = description;
        this.longDescription = longDescription;
        this.questions = questions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        title = value;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable value) {
        icon = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        description = value;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String value) {
        longDescription = value;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> value) {
        questions = value;
    }
}
