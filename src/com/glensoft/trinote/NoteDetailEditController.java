package com.glensoft.trinote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class NoteDetailEditController implements Initializable {
	
	@FXML
	TextField name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setText("bugger off");
	}

}
