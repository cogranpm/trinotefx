package com.glensoft.trinote;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class NotebookEditController implements Initializable {
	
	@FXML
	TextField txtName;
	
	@FXML
	TextArea txtComments;
	
	@FXML
	Button btnOK;
	
	@FXML
	Button btnCancel;
	
	private NoteBook _model;
	private Boolean _isModelDirty;
	
	public void setNotebook(NoteBook noteBook)
	{
		_model = noteBook;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		_isModelDirty = false;
	}
	
	private Boolean Validate()
	{
		if (this.txtName.getLength() == 0)
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Validation Error");
			alert.setHeaderText("There was an error in the Notebook");
			alert.setContentText("The Name must be supplied.");
			alert.showAndWait();
			return false;
		}
		return true;
	}
	
	@FXML
	private void handleOK() {
		if (this._isModelDirty || (this._model.getId() == 0l)) {
			if (!Validate()){return;}
			this._model.setName(this.txtName.getText());
			this._model.setComments(this.txtComments.getText());
			if(this._model.getId() == 0l)
			{
				Context.getInstance().getProvider().putNotebook(this._model);
			}
			else
			{
				Context.getInstance().getProvider().postNotebook(this._model);
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
			this.txtComments.setText(_model.getComments());
		}	
	}
	
}
