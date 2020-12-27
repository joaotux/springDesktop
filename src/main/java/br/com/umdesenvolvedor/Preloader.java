package br.com.umdesenvolvedor;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Preloader extends javafx.application.Preloader {
	Stage stage;
    private Parent parent;

    private Scene createPreloaderScene() throws IOException {
        parent = (Parent) new FXMLLoader(getClass().getClassLoader().getResource("/templates/PreloaderFXML.fxml")).load();

        return new Scene(parent);
    }

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Carregando...");
        stage.setScene(createPreloaderScene());
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.show();

        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification evt) {
        if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
            stage.hide();
        }
    }
}
