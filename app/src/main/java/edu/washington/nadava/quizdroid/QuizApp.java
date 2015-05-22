package edu.washington.nadava.quizdroid;

import android.app.Application;
import android.util.Log;

import org.json.JSONException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import edu.washington.nadava.quizdroid.topic.InMemoryTopicRepository;
import edu.washington.nadava.quizdroid.topic.JsonTopicRepository;
import edu.washington.nadava.quizdroid.topic.TopicRepository;

/**
 * Created by nadavash on 5/7/15.
 */
public class QuizApp extends Application {
    public static final String TAG = "QuizApp";

    private static QuizApp instance;

    private TopicRepository topicRepo;

    public QuizApp() throws JSONException {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("Cannot instantiate more than one instance of QuizApp.");
        }
    }

    public void loadTopicRepo(File f) {
        if (f == null) {
            topicRepo = new InMemoryTopicRepository();
            return;
        }
        try {
            InputStream istream = new FileInputStream(f);
            topicRepo = new JsonTopicRepository(istream);
        } catch (FileNotFoundException e) {
            topicRepo = new InMemoryTopicRepository();
        } catch (JSONException e) {
            topicRepo = new InMemoryTopicRepository();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Loaded application class.");
    }

    public TopicRepository getTopicRepository() {
        return topicRepo;
    }
}
