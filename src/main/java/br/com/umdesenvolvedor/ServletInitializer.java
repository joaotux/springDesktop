package br.com.umdesenvolvedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class ServletInitializer extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent parent;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(ServletInitializer.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/templates/FXMLMain.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		parent = fxmlLoader.load();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(parent));
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		springContext.close();
	}

}
