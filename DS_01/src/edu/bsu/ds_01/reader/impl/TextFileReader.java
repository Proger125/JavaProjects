package edu.bsu.ds_01.reader.impl;

import edu.bsu.ds_01.reader.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class TextFileReader implements Reader {
    @Override
    public String readFile(String fileName) throws FileNotFoundException {
        String extension = fileName.substring(fileName.lastIndexOf('.'));
        if (!extension.equals(".txt") && !extension.equals(".docx")){
            throw new IllegalArgumentException("Incorrect fileName:" + fileName);
        }
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        Stream<String> lines = reader.lines();
        lines.forEach(str -> builder.append(str).append('\n'));
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
