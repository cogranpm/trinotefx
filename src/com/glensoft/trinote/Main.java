package com.glensoft.trinote;
	
import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;


public class Main extends Application  {
	@Override
	public void start(Stage primaryStage) {
		try {
			Context.getInstance().getProvider().Connect();
			Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
			Scene scene = new Scene(root,bounds.getWidth(),bounds.getHeight());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		Context.getInstance().getProvider().Disconnect();
		super.stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
