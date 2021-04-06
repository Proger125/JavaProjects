package sample;

import javafx.scene.control.TextArea;

public class Component2 implements EventListener{
    public TextArea area = new TextArea();
    public Component2(){
        area.setEditable(false);
        area.setMaxWidth(100);
        area.setFocusTraversable(false);
    }

    @Override
    public void update(String keyPressed) {
        area.appendText(keyPressed + '\n');
    }
}
