package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller implements Initializable{
    private final Model model;
    public TextField field;
    public ComboBox comboBox;
    public Circle circle;
    public Controller(){
        model = new Model();
        model.addElement("Натуральное число", RegularExpressions.NATURAL_REGEXP);
        model.addElement("Целое число", RegularExpressions.INTEGER_REGEXP);
        model.addElement("Дробное число", RegularExpressions.DOUBLE_REGEXP);
        model.addElement("Дата", RegularExpressions.DATE_REGEXP);
        model.addElement("Email", RegularExpressions.EMAIL_REGEXP);
        model.addElement("Время", RegularExpressions.TIME_REGEXP);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                String str = field.getText();
                check(str);
            }
        });
        field.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                check(t1);
            }
        });
    }
    private void check(String t1){
        Pattern pattern = model.getRegularExpresion((String)comboBox.getValue());
        Matcher matcher = pattern.matcher(t1);
        if (matcher.matches()){
            circle.setFill(Color.GREEN);
        }else{
            circle.setFill(Color.RED);
        }
    }
}
