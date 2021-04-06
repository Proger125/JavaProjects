package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Controller implements Initializable {
    private static final String DATE_REGEXP = "((((0[1-9]|1[0-9]|2[0-8])[\\.](0[1-9]|1[012]))|((29|30|31)[\\.](0[13578]|1[02]))|((29|30)[\\.](0[4,6,9]|11)))[\\.](19|[2-9][0-9])\\d\\d)|(29[\\.]02[\\.](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96))";
    public ListView list;
    public TextArea area;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        area.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                Pattern pattern = Pattern.compile(DATE_REGEXP);
                Matcher matcher = pattern.matcher(t1);
                ArrayList<String> arrayList = new ArrayList<>();
                int start = 0;
                while (matcher.find(start)){
                    arrayList.add(matcher.group());
                    start = matcher.end();
                }
                list.setItems(FXCollections.observableArrayList(arrayList));
            }
        });
    }
}
