package com.glensoft.trinote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteDetailEditController implements Initializable {
	

	@FXML
	TextArea txtBody;
	
	@FXML
	TextArea txtSourceCode;
	
	@FXML
	TextArea txtComments;
	
	private NoteDetail _model;
	
	public void setNoteDetail(NoteDetail noteDetail)
	{
		_model = noteDetail;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	public void renderModel()
	{
		if (_model != null)
		{
		txtBody.setText(_model.getBody());
		txtSourceCode.setText(_model.getSourceCode());
		txtComments.setText(_model.getComments());
		}	
	}
	

}
