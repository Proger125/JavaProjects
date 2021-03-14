package com.company;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Model {
    private ProgrammingLanguage[] languages;
    public Model(ProgrammingLanguage[] languages){
        this.languages = new ProgrammingLanguage[languages.length];
        for (int i = 0; i < languages.length; i++){
            this.languages[i] = languages[i];
        }
    }
    public CategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (ProgrammingLanguage language : languages){
            dataset.addValue(language.getPopularity(), language.getName(), language.getName());
        }
        return dataset;
    }
}
