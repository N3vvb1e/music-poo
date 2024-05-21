package application;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws MusicInitializationException {
        try {
            primaryStage.setResizable(false);
            URL url = new File("src/resources/view/MusicView.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setTitle("Music Manager");

        } catch(Exception e) {
            e.printStackTrace();
            throw new MusicInitializationException("Error occurred during music initialization");  //este / nu este nevoie sa fiti obligat sa tratati aceasta exceptie
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}