package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller implements EventListener{
    public Label label;
    public TextArea area;

    @Override
    public void update(String keyPressed) {
        label.setText(keyPressed);
        area.appendText(keyPressed + '\n');
    }
}
