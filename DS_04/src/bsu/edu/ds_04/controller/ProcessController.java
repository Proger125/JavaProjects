package bsu.edu.ds_04.controller;

import bsu.edu.ds_04.model.CustomModel;
import bsu.edu.ds_04.view.CustomView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record ProcessController(CustomModel model,
                                CustomView view) implements ActionListener {

    private static final String STRING_REGEX = "\\\\?\"[\\sa-zA-Zа-яА-Я0-9(){}.,?!_=\\-+\\\\]*?\\\\?\"";
    private static final String WORD_REGEX = "^[a-zA-z_][a-zA-Z0-9_.,;:!?\\[\\]\\(\\)]*$";

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = model.getText();
        String[] lines = text.split("\n");
        Pattern pattern = Pattern.compile(STRING_REGEX);

        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < lines.length; k++){
            if (lines[k].contains("\"")){
                List<Integer> indexes = new ArrayList<>();
                indexes.add(0);
                Matcher matcher = pattern.matcher(lines[k]);
                while (matcher.find()){
                    if (lines[k].charAt(matcher.start()) == '\\'){
                        indexes.remove(indexes.size() - 1);
                    }else{
                        indexes.add(matcher.start());
                    }
                    indexes.add(matcher.end());
                }
                indexes.add(lines[k].length());
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < indexes.size() - 1; i++){
                    String line = lines[k].substring(indexes.get(i), indexes.get(i + 1));
                    if (i % 2 == 0){
                        line = line.replaceAll("[0-9]", "");
                    }
                    builder.append(line);
                }
                lines[k] = builder.toString();
            }else{
                String[] words = lines[k].split(" ");
                Pattern wordPattern = Pattern.compile(WORD_REGEX);
                for (int i = 0; i < words.length; i++){
                    Matcher matcher = wordPattern.matcher(words[i]);
                    if (matcher.matches()){
                        words[i] = words[i].replaceAll("[0-9]", "");
                    }
                }
                String resultLine = "";
                for (String word : words) {
                    if (word.equals(" ") || word.equals(words[words.length - 1])){
                        resultLine = resultLine.concat(word);
                    }else{
                        resultLine = resultLine.concat(word).concat(" ");
                    }
                }

                lines[k] = resultLine;
            }
            stringBuilder.append(lines[k]).append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        view.setResultAreaText(stringBuilder.toString());
        model.setResultText(stringBuilder.toString());
    }
}
