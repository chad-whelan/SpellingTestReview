package com.cwhelan.spellingtestreview.creation;

import com.cwhelan.spellingtestreview.model.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chadwhelan on 1/25/15.
 */
public class CorrectWordCreator extends AbstractQuestionCreator {

    private List<Question> questions = new ArrayList<>();

    public CorrectWordCreator(String questionFileName) {

    }

    @Override
    public List<Question> getQuestions() {
        return null;
    }
}
