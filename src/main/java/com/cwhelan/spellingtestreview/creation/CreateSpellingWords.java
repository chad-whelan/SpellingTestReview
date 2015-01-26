package com.cwhelan.spellingtestreview.creation;

import com.cwhelan.spellingtestreview.file.CSVWordFileReader;
import com.cwhelan.spellingtestreview.file.WordFileReader;
import com.cwhelan.spellingtestreview.model.SpellingWord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chadwhelan on 1/25/15.
 */
public class CreateSpellingWords {

    private List<SpellingWord> spellingWords = new ArrayList<>();

    public CreateSpellingWords(String wordFileName) {
        readFile(wordFileName);
    }

    public List<SpellingWord> getSpellingWords() {
        return spellingWords;
    }

    private void readFile(String wordFileName) {
        WordFileReader reader = new CSVWordFileReader(wordFileName);
        List<String> fileLines = reader.getFileLines();
        parseFile(fileLines);
    }

    private void parseFile(List<String> lines) {

        for (String line : lines) {

            if (line != null && !line.isEmpty()) {
                String[] words = line.split(",");

                if (words != null && words.length > 1) {
                    SpellingWord word = new SpellingWord();
                    word.setCorrectSpelling(words[0]);

                    for (int i = 1; i < words.length; i++) {
                        word.getIncorrectChoices().add(words[i]);
                    }

                    spellingWords.add(word);
                }
            }
        }
    }

}
