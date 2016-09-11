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
	TextField txtName;

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
		if (this._isModelDirty || (this._model.getId() == 0l)) {
			this._model.setName(this.txtName.getText());
			this._model.setBody(this.txtBody.getText());
			this._model.setComments(this.txtComments.getText());
			this._model.setSourceCode(this.txtSourceCode.getText());
			if(this._model.getId() == 0l)
			{
				Context.getInstance().getProvider().putNoteDetail(this._model);
			}
			else
			{
				Context.getInstance().getProvider().postNoteDetail(this._model);
			}
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
			this.txtName.setText(_model.getName());
			this.txtBody.setText(_model.getBody());
			this.txtSourceCode.setText(_model.getSourceCode());
			this.txtComments.setText(_model.getComments());
		}	
	}
	

}
