package com.glensoft.trinote;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

public class MainController implements Initializable{
	
	@FXML
	private ListView<NoteBook> lstNotebooks;
	
	@FXML
	private ListView<NoteHeader> lstNoteheaders;
	
	@FXML
	private ListView<NoteDetail> lstNotedetails;
	
	@FXML
	private MenuBar mnuMain;
	
	@FXML
	private void handleFileMenuQuit()
	{
		Stage stage = (Stage)mnuMain.getScene().getWindow();
		stage.close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	       List<NoteBook> notebooks = Context.getInstance().getProvider().getNotebooks();
	       
	       ObservableList<NoteBook> observableList = FXCollections.observableList(notebooks);
	       lstNotebooks.setItems(observableList);
	 
	       lstNotebooks.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	    	    if (newSelection != null) {
	    	    	List<NoteHeader> noteheaders = Context.getInstance().getProvider().getNoteheaders(newSelection.getId());
	    	        ObservableList<NoteHeader> lstUiNoteHeaders = FXCollections.observableList(noteheaders);
	    	        lstNoteheaders.setItems(lstUiNoteHeaders);
	    	    }
	    	});
	       
	       lstNoteheaders.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	    	    if (newSelection != null) {
	    	    	List<NoteDetail> notedetails = Context.getInstance().getProvider().getNotedetails(newSelection.getId());
	    	        ObservableList<NoteDetail> lstUiNoteDetails = FXCollections.observableList(notedetails);
	    	        lstNotedetails.setItems(lstUiNoteDetails);
	    	    }
	    	});
	       
	       
	       lstNotebooks.setCellFactory(new Callback<ListView<NoteBook>, ListCell<NoteBook>>(){
	            @Override
	            public ListCell<NoteBook> call(ListView<NoteBook> p) {
				ListCell<NoteBook> cell = new ListCell<NoteBook>() {
					@Override
					protected void updateItem(NoteBook t, boolean bln) {
						super.updateItem(t, bln);
						if (t != null) {
							setText(t.getName());
							setOnMouseClicked(null);

						} else {
							setText("");
							setOnMouseClicked(null);
						}
					}

				};
	                return cell;
	            }
	            
	            
	            
	        });   
	       
	       lstNoteheaders.setCellFactory(new Callback<ListView<NoteHeader>, ListCell<NoteHeader>>(){
	            @Override
	            public ListCell<NoteHeader> call(ListView<NoteHeader> p) {
	                ListCell<NoteHeader> cell = new ListCell<NoteHeader>(){
	                    @Override
	                    protected void updateItem(NoteHeader t, boolean bln) {
	                        super.updateItem(t, bln);
	                        if (t != null) {
	                            setText(t.getName());
	                        }
	                        else
	                        {
	                        	setText("");
	                        }
	                    }	 
	                };
	                return cell;
	            }
	        });  
	       
	       lstNotedetails.setCellFactory(new Callback<ListView<NoteDetail>, ListCell<NoteDetail>>(){
	            @Override
	            public ListCell<NoteDetail> call(ListView<NoteDetail> p) {
	                ListCell<NoteDetail> cell = new ListCell<NoteDetail>(){
	                    @Override
	                    protected void updateItem(NoteDetail t, boolean bln) {
	                        super.updateItem(t, bln);
	                        if (t != null) {
	                            setText(t.getName());
	                            setOnMouseClicked((MouseEvent event) -> 
	                            {
	                            	if(event.getClickCount() > 1)
	                            	{
	                            		NoteDetailEditDialogManager mng = new NoteDetailEditDialogManager();
	                            		Node eventSource = (Node)event.getSource();
	                            		Scene parentScene = eventSource.getScene();
	                            		Window parentWin = parentScene.getWindow();
	                            		mng.ShowDialog(parentWin, lstNotedetails.getSelectionModel().getSelectedItem());
	                            	}
	                            });
	                        }
	                        else
	                        {
	                        	setText("");
	                        	setOnMouseClicked(null);
	                        }
	                    }	 
	                };
	                return cell;
	            }
	        });  
	       
	
	       
	       observableList.addListener(new ListChangeListener<NoteBook>() {
	           @Override
	           public void onChanged(ListChangeListener.Change change) {
	               System.out.println("Detected a change! ");
	           }
	       });     
	       
	       
	 	
	}
	
}
