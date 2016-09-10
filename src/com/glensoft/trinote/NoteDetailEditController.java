package com.glensoft.trinote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NoteDetailEditController implements Initializable {
	

	@FXML
	TextArea txtBody;
	
	@FXML
	TextArea txtSourceCode;
	
	@FXML
	TextArea txtComments;
	
	@FXML
	Button btnOK;
	
	@FXML
	Button btnCancel;
	
	private NoteDetail _model;
	private Boolean _isModelDirty;
	
	public void setNoteDetail(NoteDetail noteDetail)
	{
		_model = noteDetail;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		_isModelDirty = false;
	}
	
	@FXML
	private void handleOK() {
		if (this._isModelDirty) {
			this._model.setBody(this.txtBody.getText());
			this._model.setComments(this.txtComments.getText());
			this._model.setSourceCode(this.txtSourceCode.getText());
			Context.getInstance().getProvider().postNoteDetail(this._model);
		}
		this._isModelDirty = false;
		this.getStage().close();
	}
	
	@FXML
	private void handleCancel()
	{
		this.getStage().close();
	}
	
	@FXML
	private void handleKeyTyped(KeyEvent event)
	{
		this._isModelDirty = true;
	}
	
	private Stage getStage()
	{
		Stage stage = (Stage) btnOK.getScene().getWindow();
		return stage;		
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
