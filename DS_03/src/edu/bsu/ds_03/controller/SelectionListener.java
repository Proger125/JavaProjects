package edu.bsu.ds_03.controller;

import edu.bsu.ds_03.model.LocaleModel;
import edu.bsu.ds_03.view.CustomFrame;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.lang.reflect.Method;

public class SelectionListener implements ListSelectionListener {
    private final CustomFrame customFrame;
    private final LocaleModel localeModel;

    public SelectionListener(CustomFrame customFrame, LocaleModel localeModel){
        this.customFrame = customFrame;
        this.localeModel = localeModel;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            String methodSignature = customFrame.getFields().getMethodsList().getSelectedValue();
            String methodIndexStr = methodSignature.substring(0, methodSignature.indexOf("."));
            int methodIndex = Integer.parseInt(methodIndexStr);
            Method method = localeModel.getMethod(methodIndex - 1);
            localeModel.setCurrentMethod(method);
            int parameterCount = method.getParameterCount();

            customFrame.clearCenterPanel();
            if (parameterCount > 0){
                customFrame.showFirstParameter();
            }
            if (parameterCount > 1){
                customFrame.showSecondParameter();
            }
            if (parameterCount > 2){
                customFrame.showThirdParameter();
            }
            customFrame.showCalcButton();
        }
    }
}
