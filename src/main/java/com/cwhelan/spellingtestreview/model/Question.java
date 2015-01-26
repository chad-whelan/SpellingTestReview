package com.cwhelan.spellingtestreview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chadwhelan on 1/18/15.
 */
public class Question {

    private List<String> choices;

    public Question() {

    }

    public List<String> getChoices() {

        if (choices == null) {
            choices = new ArrayList<>();
        }
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
