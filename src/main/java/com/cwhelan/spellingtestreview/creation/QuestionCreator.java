package com.cwhelan.spellingtestreview.creation;

import com.cwhelan.spellingtestreview.model.Question;

import java.util.List;

/**
 * Created by chadwhelan on 1/25/15.
 */
public interface QuestionCreator {

    List<Question> getQuestions();
}
