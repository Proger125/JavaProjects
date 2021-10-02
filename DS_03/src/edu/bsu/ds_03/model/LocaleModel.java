package edu.bsu.ds_03.model;

import edu.bsu.ds_03.view.Fields;

import javax.swing.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Locale;

public class LocaleModel {
    private Locale locale;
    private final Fields fields;

    private final Method[] methods;
    private Method currentMethod;

    public LocaleModel(Fields fields){
        this.locale = new Locale("ru");
        this.fields = fields;

        methods = Math.class.getDeclaredMethods();

        fields.setLocale(this.locale);
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        fields.setLocale(this.locale);
    }

    public Method getMethod(int index){
        return methods[index];
    }

    public DefaultListModel<String> createMethodsListModel(){
        DefaultListModel<String> defaultListModel = new DefaultListModel<>();
        int i = 1;
        for (var method : methods){
            StringBuilder builder = new StringBuilder();
            builder.append(i).append(". ");
            builder.append(method.getReturnType()).append(" ");
            builder.append(method.getName()).append("(");
            Parameter[] parameters = method.getParameters();
            for (var param : parameters){
                builder.append(" ").append(param.getType()).append(" ").append(param.getName()).append(",");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(" )");
            defaultListModel.addElement(builder.toString());
            i++;
        }
        return defaultListModel;
    }

    public void setCurrentMethod(Method currentMethod) {
        this.currentMethod = currentMethod;
    }

    public Method getCurrentMethod(){
        return currentMethod;
    }
}
