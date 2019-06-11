package com.github.ixiongdi.sdut;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    static Stage window;


    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        stage.setTitle("广场舞U盘工具");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();

        window = stage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
