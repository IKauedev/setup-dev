package org.setup.setupdev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DevApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(DevApplication.class.getResource("dev-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Dev Setup Installer");

        stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("/icons/logo-setup.png")));
        scene.getStylesheets().add(getClass().getResource("/style/style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
