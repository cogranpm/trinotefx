
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
	private ListView lstNotebooks;
	
	 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	       List<NoteBook> notebooks = Context.getInstance().getProvider().getNotebooks();
	       
	       ObservableList<NoteBook> observableList = FXCollections.observableList(notebooks);
	       //lstNotebooks.itemsProperty().bind(observableList);
	       lstNotebooks.setItems(observableList);
	       observableList.addListener(new ListChangeListener() {

	           @Override
	           public void onChanged(ListChangeListener.Change change) {
	               System.out.println("Detected a change! ");
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
	                    }
	 
	                };
	                 
	                return cell;
	            }
	        });   
		
	}
	
}
