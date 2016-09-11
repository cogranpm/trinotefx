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

public class NoteDetailEditDialogFactory {
	
	private NoteDetail _noteDetail;
	private final String TEMPLATE_NAME = "NoteDetailEdit.fxml";
	
	public void ShowDialog(Window parentWindow, NoteDetail noteDetail) {

		this._noteDetail = noteDetail;
		FXMLLoader loader;
		NoteDetailEditController controller;
		Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
		BorderPane root;
		try {
			loader = new FXMLLoader(getClass().getResource(TEMPLATE_NAME));
			root = (BorderPane)loader.load(); 
			controller = (NoteDetailEditController) loader.getController();
			controller.setNoteDetail(noteDetail);
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Note");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.setWidth(bounds.getWidth());
			dialogStage.setHeight(bounds.getHeight());
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
