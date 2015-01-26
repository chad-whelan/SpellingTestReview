package com.cwhelan.spellingtestreview;
import com.cwhelan.spellingtestreview.creation.CreateSpellingWords;
import com.cwhelan.spellingtestreview.file.CSVWordFileReader;
import com.cwhelan.spellingtestreview.model.SpellingWord;

import java.util.*;

/**
 * Created by chadwhelan on 1/13/15.
 */
public class SpellingTestReview extends Thread {

    private String currentWordFild = "currentWords.csv";
    private String randomWordFile = "randomWords.csv";

    public static void main(String[] args) {
        new SpellingTestReview(args).start();
    }

    private SpellingTestReview(String[] programArguments) {

        if (programArguments != null && programArguments.length > 0) {
            currentWordFild = programArguments[0];

            if (programArguments.length > 1) {
                randomWordFile = programArguments[1];
            }

        }

    }

    public void run() {
        generateTest();
    }


    private void generateTest() {
        List<SpellingWord> spellingWords = new ArrayList<>();
        CreateSpellingWords currentSpellingWords = new CreateSpellingWords(currentWordFild);
        List<SpellingWord> currentWordList = currentSpellingWords.getSpellingWords();

        int rightWordChoices = Math.round(currentWordList.size() * .2F);

        for (SpellingWord word : currentSpellingWords.getSpellingWords()) {
            System.out.println(word);
        }
    }
//    private void generateTest() {
//        List<String> listWords = new ArrayList<>();
//        listWords.addAll(getCorrectTestWords());
//        int rightWordChoices = Math.round(listWords.size() * .2F);
//
//        printRightSpellingWords(listWords, rightWordChoices);
//        printWrongSpellingWords(listWords, ++rightWordChoices);
//
////        System.out.println("remaining word count: " + listWords.size());
//    }

    private void printRightSpellingWords(List<String> originalList, int stopAt) {

        System.out.println("Directions:  Circle the word that is spelled correctly.");
        List<String> incorrectWords = new ArrayList<>();
        incorrectWords.addAll(getMisspelledWords());
        List<List<String>> questions = new ArrayList<>();

        while (originalList != null && !originalList.isEmpty() && questions.size() < stopAt) {
            List<String> choices = new ArrayList<>();
            choices.add(removeRandomWord(originalList));
            choices.add(removeRandomWord(incorrectWords));
            choices.add(removeRandomWord(incorrectWords));
            choices.add(removeRandomWord(incorrectWords));
            questions.add(choices);
        }

        printQuestion(1, questions);
    }

    private void printWrongSpellingWords(List<String> originalList, int nextQuestion) {

        System.out.println("Directions:  Circle the word that is spelled incorrectly, then spell the word correctly on line.");
        List<String> correctWords = new ArrayList<>();
        correctWords.addAll(getCorrectRandomWords());

        List<List<String>> questions = new ArrayList<>();
        Map<String, String> replacements = getMisspelledTestWords();

        while (originalList != null && !originalList.isEmpty()) {
            List<String> choices = new ArrayList<>();

            String correct = removeRandomWord(originalList);
            choices.add(replacements.get(correct));
            choices.add(removeRandomWord(correctWords));
            choices.add(removeRandomWord(correctWords));
            choices.add(removeRandomWord(correctWords));
            questions.add(choices);
        }

        printQuestion(nextQuestion, questions, "__________");

    }


    private void printQuestion(int startAt, List<List<String>> questions) {
        printQuestion(startAt, questions, null);
    }


    private void printQuestion(int startAt, List<List<String>> questions, String theLine) {

        for (List<String> question : questions) {
            List<String> choices = randomizeList(question);

            System.out.format("%2d),", startAt++);

            for (String choice : choices) {
                System.out.print(choice);
                System.out.print(",");
            }

            if (theLine != null) {
                System.out.print(theLine);
            }

            System.out.println();
        }
    }

    private List randomizeList(List originalList) {
        List newList = new ArrayList<>();
        while (originalList != null && !originalList.isEmpty()) {
            newList.add(removeRandomWord(originalList));
        }

        return newList;
    }

    private <T> T removeRandomWord(List<T> originalList) {
        T t = randomValue(originalList);
        originalList.remove(t);
        return t;
    }

    private <T> T randomValue(List<T> list) {
        Integer index = (int) (Math.random() * list.size());
        return list.get(index);
    }

    private List<String> getCorrectTestWords() {
        return Arrays.asList("wolves","women","geese","knew","knives","sheep","wives","know","feet","heroes","elves","instead",
                "men","scarves","banjos","letter","children","mice","halves","library","I like zoos.");
    }

    private Map<String, String> getMisspelledTestWords() {
        Map<String, String> incorrectWords = new HashMap<>();

        incorrectWords.put("let's", "lit's");
        incorrectWords.put("he'd", "hee'd");
        incorrectWords.put("you'll", "you'l");
        incorrectWords.put("can't", "cna't");
        incorrectWords.put("I'd", "I'ld");
        incorrectWords.put("won't", "win't");
        incorrectWords.put("hasn't", "hassn't");
        incorrectWords.put("she'd", "she'ld");
        incorrectWords.put("they'll", "the'll");
        incorrectWords.put("when's", "win's");
        incorrectWords.put("we'd", "we'");
        incorrectWords.put("should've", "shold've");
        incorrectWords.put("wasn't", "was't");
        incorrectWords.put("didn't", "dind't");
        incorrectWords.put("haven't", "havn't");
        incorrectWords.put("thumb", "thomb");
        incorrectWords.put("gnaw", "knaw");
        incorrectWords.put("written", "writen");
        incorrectWords.put("know", "knwo");
        incorrectWords.put("climb", "clim");
        incorrectWords.put("design", "disign");
        incorrectWords.put("wrist", "wist");
        incorrectWords.put("crumb", "crum");
        incorrectWords.put("assign", "asign");
        incorrectWords.put("wrench", "wrinch");
        incorrectWords.put("knot", "nkot");
        incorrectWords.put("wrinkle", "rinkle");
        incorrectWords.put("lamb", "lam");
        incorrectWords.put("unhappy", "unhapy");
        incorrectWords.put("recall", "recal");
        incorrectWords.put("disappear", "dissappear");
        incorrectWords.put("unload", "unlod");
        incorrectWords.put("mistake", "misstake");
        incorrectWords.put("misspell", "mispell");
        incorrectWords.put("dislike", "disslike");
        incorrectWords.put("replace", "repalce");
        incorrectWords.put("mislead", "mislaed");
        incorrectWords.put("disagree", "disagre");
        incorrectWords.put("rewrite", "rerite");
        incorrectWords.put("unroll", "unrol");
        incorrectWords.put("unknown", "unnown");
        incorrectWords.put("dishonest", "dishonist");
        incorrectWords.put("react", "raect");
        incorrectWords.put("knob", "nob");
        incorrectWords.put("knit", "gnit");
        incorrectWords.put("clock", "cloc");
        incorrectWords.put("large", "larg");
        incorrectWords.put("page", "pag");
        incorrectWords.put("mark", "marc");
        incorrectWords.put("kitten", "kiten");
        incorrectWords.put("judge", "jidge");
        incorrectWords.put("crack", "crac");
        incorrectWords.put("edge", "edg");
        incorrectWords.put("pocket", "poket");
        incorrectWords.put("brake", "braek");
        incorrectWords.put("change", "chang");
        incorrectWords.put("ridge", "ridg");
        incorrectWords.put("jacket", "jackit");
        incorrectWords.put("badge", "badg");
        incorrectWords.put("first", "fisrt");
        incorrectWords.put("beautiful", "beautifull");
        incorrectWords.put("safely", "safly");
        incorrectWords.put("kindness", "kindnes");
        incorrectWords.put("finally", "finaly");
        incorrectWords.put("spotless", "spotliss");
        incorrectWords.put("worthless", "worthles");
        incorrectWords.put("illness", "ilness");
        incorrectWords.put("helpful", "heplful");
        incorrectWords.put("daily", "daly");
        incorrectWords.put("suddenly", "sudenly");
        incorrectWords.put("wireless", "wirless");
        incorrectWords.put("quietly", "quitly");
        incorrectWords.put("fairness", "fareness");
        incorrectWords.put("cheerful", "cherful");
        incorrectWords.put("painful", "pinfull");

        return incorrectWords;
    }

    private List<String> getMisspelledWords() {
        return Arrays.asList("agian", "allways ", "annd", "anemals", "anothir", "arond", "ascked", "babes", "becase",
                "befor", "beleive", "boght", "cam", "caut ", "chidlren", "cloths", "comeing", "corse", "cusin",
                "desided", "diferent", "droped ", "evrey", "Febuary",  "freind", "frends", "fritened", "frrom",
                "geting", "hapening", "hearr", "haerd", "heer", "hiem", "interisting", "itts", "itt's", "jomped",
                "kenw", "lik", "litte", "loked", "mnay ", "mony", "moning", "motther", "namme", "namd", "ofe", "oncce",
                "ur", "peple", "prety", "recieved", "runing", "siad", "schole", "someting", "sometims",
                "statred", "stoped", "stoopped", "surpise", "swiming", "thaan", "tha's", "thier", "tthen", "tehre", "htey", "the're",
                "thinngs", "thout", "threwe", "throgh", "togeter", "ttoo", "tooo", "tryed", "ttwo", "untill", "veary", "viry", "wated",
                "wint", "weere","weire",  "whin", "wherre", "wih", "womans", "wold", "you'e", "hee'd","you'l", "cna't", "hassn't",
                "the'll","shold've", "was't", "dind't", "havn't","knaw","writen", "knwo", "clim", "disign", "wist", "crum","asign",
                "wrinch", "nkot","rinkle", "lam","unhapy","recal","dissappear","unlod","misstake","mispell","disslike","repalce",
                "mislaed","disagre","rerite", "unrol","unnown","dishonist","raect","cloc","larg","pag","kiten","crac","poket","braek",
                "chang", "jackit","badg", "fisrt", "beautifull", "safly", "kindnes", "finaly","spotliss", "worthles","ilness",
                "heplful", "daly","sudenly", "wirless", "quitly","fareness", "cherful", "pinfull");
    }

    private List<String> getCorrectRandomWords() {
        return Arrays.asList("again", "agree", "alphabet", "already", "always", "amount", "and", "angrier",
                "animals", "annoy", "another", "appoint", "around", "asked", "athlete", "avoid", "babies",
                "because", "before", "believe", "blueberry", "bodies", "bought", "bounce", "braid", "broil", "bunches",
                "butterflies", "came", "camel", "campground", "catch", "caught ", "chapter", "cheese", "children", "choice",
                "clean", "clothes", "coach", "coming", "copies", "course", "cousin", "crashes", "decided",
                "different", "display", "dream", "dropped", "easiest", "employ", "emptied", "English", "even", "every",
                "families", "family", "fashion", "father", "February", "female", "finish",  "flash", "float",
                "focus", "football", "for", "freezing", "Friday", "friend", "friends", "frightened", "from", "funniest",
                "gentle", "getting", "glasses", "going", "grain", "greatest", "haircut", "handle", "happening", "hear",
                "heard", "heavier", "here", "him", "homework", "hour", "inches", "interesting", "its", "it's", "juggle",
                "jumped", "knew",  "lawnmower", "leaving", "lemon", "like", "lists", "little", "looked",
                "many ", "middle", "Monday", "money", "morning", "mother", "music", "name", "named", "nephew", "noodle",
                "off", "once", "other", "our", "orange", "parties", "peach", "pencils", "pennies", "people", "pickle",
                "pilot", "pitcher", "plants", "pleased", "pockets", "poison", "poodle", "popcorn", "pretty", "proud",
                "prowl", "pupil", "railroad", "rapid", "received", "riddle", "robot", "rockets", "running", "saddle",
                "said", "salad", "sandbox", "Saturday", "scarecrow", "school", "scratch", "scream", "shadow", "shopped",
                "shower", "shrink", "silent", "simple", "snowstorm", "some", "something", "sometimes", "splash", "split",
                "splurge", "square", "squeak", "squeeze", "started", "stopped", "strangest", "street", "strength", "strike",
                "Sunday", "sunglasses", "supplies", "surprise", "swimming", "table", "teeth", "than", "that's", "their",
                "then", "there", "they", "they're", "things", "thought", "thousand", "three", "threw", "thrill", "throne",
                "through", "throw", "thrown", "Thursday", "to", "together", "too", "toothbrush", "tried", "trophy", "trouble",
                "Tuesday", "tulip", "two", "uncle", "until", "using", "very", "voyage", "wagon", "wanted", "watch", "weather",
                "Wednesday", "went", "were", "when", "where", "window", "wishes", "with", "woman", "worried", "would", "you're",
                "let's", "he'd", "you'll", "can't", "I'd", "won't", "hasn't", "she'd", "they'll", "when's", "we'd", "should've",
                "wasn't", "didn't", "haven't", "thumb", "gnaw", "written", "know", "climb", "design", "wrist", "crumb", "assign",
                "wrench", "knot", "wrinkle", "lamb", "unhappy", "recall", "disappear", "unload", "mistake", "misspell", "dislike",
                "replace", "mislead", "disagree", "rewrite", "unroll", "unknown", "dishonest", "react", "knob", "knit", "clock",
                "large", "page", "mark", "kitten", "judge", "crack", "edge", "pocket", "brake", "change", "ridge", "jacket",
                "badge", "first", "beautiful", "safely", "kindness", "finally", "spotless", "worthless", "illness", "helpful",
                "daily", "suddenly", "wireless", "quietly", "fairness", "cheerful", "painful");
    }
}
