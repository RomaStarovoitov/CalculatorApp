package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CalculatorApp extends Application{
	
	
	public static void main(String[] args) {
		CalculatorApp.launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("CalculatorMainView.fxml"));
		Pane pane=loader.load();
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
        stage.show();		
	}

}
