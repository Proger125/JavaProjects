package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class Components implements EventListener{
    public Label label = new Label();
    public TextArea area = new TextArea();
    public Components(){
        area.setEditable(false);
        area.setMaxWidth(100);
        area.setFocusTraversable(false);
        label.setMaxWidth(250);
        Font font = new Font(30);
        label.setFont(font);
    }
    @Override
    public void update(String keyPressed) {
        label.setText(keyPressed);
        area.appendText(keyPressed + '\n');
    }
}
