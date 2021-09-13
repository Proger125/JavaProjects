package edu.bsu.ds_01.controller.option;

import edu.bsu.ds_01.controller.OptionController;
import edu.bsu.ds_01.model.OptionFileModel;
import edu.bsu.ds_01.model.TextModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class CheckTransfersController extends OptionController implements ActionListener {
    private static final String PUNCTUATION = ",./\"'!?:;<>()";
    private final TextModel textModel;
    public CheckTransfersController(OptionFileModel model, TextModel textModel) {
        super(model);
        this.textModel = textModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = textModel.getText();
        List<String> words = splitTextToWords(text);
        Map<String, String> incorrectWords = getIncorrectWords(words);
        model.setIncorrectWordsAmount(incorrectWords.size());
        for (var pair : incorrectWords.entrySet()){
            JOptionPane.showMessageDialog(null, pair.getKey() + " is incorrect. Change to " + pair.getValue());
        }
    }

    private Map<String, String> getIncorrectWords(List<String> words){
        Map<String, String> result = new HashMap<>();
        for (var word : words){
            if (word.contains("-")){
                String wordWithOutPunctuation = word;
                if (PUNCTUATION.contains(String.valueOf(wordWithOutPunctuation.charAt(0)))){
                    wordWithOutPunctuation = removeCharAt(wordWithOutPunctuation, 0);
                }
                if (PUNCTUATION.contains(String.valueOf(wordWithOutPunctuation.charAt(wordWithOutPunctuation.length() - 1)))){
                    wordWithOutPunctuation = removeCharAt(wordWithOutPunctuation, wordWithOutPunctuation.length() - 1);
                }
                String wordWithOutDash = removeCharAt(wordWithOutPunctuation.toLowerCase(), wordWithOutPunctuation.indexOf('-'));
                String correctTransferWord = model.getRule(wordWithOutDash);
                if (correctTransferWord != null){
                    int indexOfDash = wordWithOutPunctuation.indexOf('-');
                    int index = correctTransferWord.indexOf('-');
                    boolean flag = false;
                    while (index >= 0){
                        if (index == indexOfDash){
                            flag = true;
                            break;
                        }else{
                            index = correctTransferWord.indexOf('-', index + 1);
                        }
                    }
                    if (!flag){
                        result.put(wordWithOutPunctuation, correctTransferWord);
                    }
                }
            }
        }
        return result;
    }

    private String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }

    private List<String> splitTextToWords(String text){
        String[] words = text.split("\\s");
        List<String> result = new ArrayList<>();
        for (var word : words){
            if (!word.equals("-")){
                result.add(word);
            }
        }
        model.setWordAmount(result.size());
        return result;
    }
}
