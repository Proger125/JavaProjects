package com.company;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        ProgrammingLanguage[] languages = gson.fromJson(new FileReader("res/input.json"), ProgrammingLanguage[].class);
        Model model = new Model(languages);
        View view = new View("Диаграмма", model);
    }
}
