package edu.bsu.ds_01.model;

import edu.bsu.ds_01.view.CustomFrame;

import java.util.HashMap;
import java.util.Map;

public class OptionFileModel {
    private Map<String, String> rules = new HashMap<>();
    private String fileName;
    private final CustomFrame frame;
    private int incorrectWordsAmount = 0;
    private int wordAmount = 0;

    public OptionFileModel(CustomFrame frame) {
        this.frame = frame;
    }

    public void setWordAmount(int wordAmount) {
        this.wordAmount = wordAmount;
        frame.setWordAmount(Integer.toString(wordAmount));
    }

    public int getIncorrectWordsAmount() {
        return incorrectWordsAmount;
    }

    public void setIncorrectWordsAmount(int incorrectWordsAmount) {
        this.incorrectWordsAmount = incorrectWordsAmount;
        frame.setMistakeAmount(Integer.toString(incorrectWordsAmount));
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        frame.enableCheckButton();
    }

    public Map<String, String> getRules() {
        return rules;
    }

    public void setRules(Map<String, String> rules) {
        this.rules = rules;
    }

    public String getRule(String key){
        return rules.get(key);
    }
}
