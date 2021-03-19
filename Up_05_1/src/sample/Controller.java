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
        model.addElement("Натуральное число", "^(\\+?[1-9][0-9]*)$");
        model.addElement("Целое число", "^(0|[-\\+]?[1-9][0-9]*)$");
        model.addElement("Дробное число", "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)+(?:[eE][-\\\\+]?[0-9]+)?$");
        model.addElement("Дата", "(^(((0[1-9]|1[0-9]|2[0-8])[\\.](0[1-9]|1[012]))|((29|30|31)[\\.](0[13578]|1[02]))|((29|30)[\\.](0[4,6,9]|11)))[\\.](19|[2-9][0-9])\\d\\d$)|(^29[\\.]02[\\.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)");
        model.addElement("Email", "[a-z].?([-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(com|net|org|pro|tel|travel)");
        model.addElement("Время", "^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$");
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
