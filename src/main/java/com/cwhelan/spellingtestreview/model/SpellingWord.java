package com.cwhelan.spellingtestreview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chadwhelan on 1/25/15.
 */
public class SpellingWord {

    private String correctSpelling;
    private List<String> incorrectChoices;

    public String getCorrectSpelling() {
        return correctSpelling;
    }

    public void setCorrectSpelling(String correctSpelling) {
        this.correctSpelling = correctSpelling;
    }

    public List<String> getIncorrectChoices() {

        if (incorrectChoices == null) {
            incorrectChoices = new ArrayList<>();
        }

        return incorrectChoices;
    }

    public void setIncorrectChoices(List<String> incorrectChoices) {
        this.incorrectChoices = incorrectChoices;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SpellingWord{");
        sb.append("correctSpelling='").append(correctSpelling).append('\'');
        sb.append(", incorrectChoices=").append(incorrectChoices);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpellingWord that = (SpellingWord) o;

        if (!correctSpelling.equals(that.correctSpelling)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return correctSpelling.hashCode();
    }
}
