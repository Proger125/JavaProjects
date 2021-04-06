package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

public class Main extends Application {
    public EventManager manager = new EventManager();

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Up_07");
        Component1 component1 = new Component1();
        Component2 component2 = new Component2();
        manager.subscribe(component1);
        manager.subscribe(component2);
        BorderPane pane = new BorderPane();
        pane.setLeft(component1.label);
        pane.setRight(component2.area);

        Scene scene = new Scene(pane, 500, 275);
        scene.setOnKeyPressed(keyEvent -> {
            KeyCode code = keyEvent.getCode();
            String keyPressed = KeyEvent.getKeyText(code.getCode());
            manager.not(keyPressed);
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
