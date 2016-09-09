
 package com.glensoft.trinote;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.glensoft.trinote.data.*;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class MainController implements Initializable{
	
	@FXML
	private ListView<NoteBook> lstNotebooks;
	
	@FXML
	private ListView<NoteHeader> lstNoteheaders;
	
	@FXML
	private ListView<NoteDetail> lstNotedetails;
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	       List<NoteBook> notebooks = Context.getInstance().getProvider().getNotebooks();
	       
	       ObservableList<NoteBook> observableList = FXCollections.observableList(notebooks);
	       lstNotebooks.setItems(observableList);
	 
	       lstNotebooks.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
	    	    if (newSelection != null) {
	    	    	//lstNoteheaders.setItems(null);
	    	    	List<NoteHeader> noteheaders = Context.getInstance().getProvider().getNoteheaders(newSelection.getId());
	    	        ObservableList<NoteHeader> lstUiNoteHeaders = FXCollections.observableList(noteheaders);
	    	        lstNoteheaders.setItems(lstUiNoteHeaders);
	    	    }
	    	});
	       
	       lstNotebooks.setCellFactory(new Callback<ListView<NoteBook>, ListCell<NoteBook>>(){
	            @Override
	            public ListCell<NoteBook> call(ListView<NoteBook> p) {
	                ListCell<NoteBook> cell = new ListCell<NoteBook>(){
	                    @Override
	                    protected void updateItem(NoteBook t, boolean bln) {
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
	
	       
	       observableList.addListener(new ListChangeListener<NoteBook>() {
	           @Override
	           public void onChanged(ListChangeListener.Change change) {
	               System.out.println("Detected a change! ");
	           }
	       });     
	       
	       
	 	
	}
	
}
