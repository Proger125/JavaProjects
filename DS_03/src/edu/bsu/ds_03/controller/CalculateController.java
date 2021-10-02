package edu.bsu.ds_03.controller;

import edu.bsu.ds_03.model.LocaleModel;
import edu.bsu.ds_03.view.Fields;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class CalculateController implements ActionListener {
    private final LocaleModel localeModel;
    private final Fields fields;

    public CalculateController(LocaleModel localeModel, Fields fields){
        this.localeModel = localeModel;
        this.fields = fields;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Method method = localeModel.getCurrentMethod();
        int parameterCount = method.getParameterCount();
        Parameter[] parameters = method.getParameters();

        String firstParameterStr = fields.getFirstParameter().getText();
        Class<?> firstParameterType = parameters[0].getType();
        Object firstParameter;
        try {
            firstParameter = parseParameter(firstParameterStr, firstParameterType);
        }catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(null, "First parameter is incorrect");
            return;
        }

        String secondParameterStr;
        Class<?> secondParameterType;
        Object secondParameter = null;
        if (parameterCount > 1){
            secondParameterStr = fields.getSecondParameter().getText();
            secondParameterType = parameters[1].getType();
            try {
                secondParameter = parseParameter(secondParameterStr, secondParameterType);
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Second parameter is incorrect");
                return;
            }
        }

        String thirdParameterStr;
        Class<?> thirdParameterType;
        Object thirdParameter = null;
        if (parameterCount > 2){
            thirdParameterStr = fields.getThirdParameter().getText();
            thirdParameterType = parameters[2].getType();
            try {
                thirdParameter = parseParameter(thirdParameterStr, thirdParameterType);
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null, "Third parameter is incorrect");
                return;
            }
        }

        Object result;
        try {
            if (parameterCount == 1) {
                result = method.invoke(Math.class, firstParameter);
            } else if (parameterCount == 2){
                result = method.invoke(Math.class, firstParameter, secondParameter);
            } else{
                result = method.invoke(Math.class, firstParameter, secondParameter, thirdParameter);
            }
            fields.getResultLabel().setText(result.toString());
        } catch (IllegalAccessException | InvocationTargetException exception) {
            exception.printStackTrace();
        }
    }

    private Object parseParameter(String parameter, Class<?> type){
        if (type == int.class){
            return Integer.parseInt(parameter);
        }
        if (type == double.class){
            return Double.parseDouble(parameter);
        }
        if (type == float.class){
            return Float.parseFloat(parameter);
        }
        if (type == long.class){
            return Long.parseLong(parameter);
        }
        return null;
    }
}
