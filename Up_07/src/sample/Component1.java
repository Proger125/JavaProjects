package sample;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;

public class Component1 implements EventListener{
    public Label label = new Label();
    public Component1(){
        label.setMaxWidth(250);
        label.setAlignment(Pos.CENTER);
        Font font = new Font(30);
        label.setFont(font);
    }
    @Override
    public void update(String keyPressed) {
        label.setText(keyPressed);

    }
}
