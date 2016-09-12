package com.glensoft.trinote;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

public class NoteHeaderEditDialogFactory {
	
	private final String TEMPLATE_NAME = "NoteHeaderEdit.fxml";
	
	public void ShowDialog(Window parentWindow, NoteHeader noteHeader) {

		FXMLLoader loader;
		NoteheaderEditController controller;
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		BorderPane root;
		try {
			loader = new FXMLLoader(getClass().getResource(TEMPLATE_NAME));
			root = (BorderPane)loader.load(); 
			controller = (NoteheaderEditController) loader.getController();
			controller.setNoteheader(noteHeader);
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Header");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(parentWindow);
			Scene scene = new Scene(root);
			dialogStage.setScene(scene);
			controller.renderModel();
			dialogStage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
