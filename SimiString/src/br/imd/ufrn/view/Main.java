package br.imd.ufrn.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Teste.fxml"));
		primaryStage.setTitle("SimiString");
		primaryStage.setScene(new Scene(root, 700 , 532));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
