package com.glensoft.trinote;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoteBook {
	private final LongProperty id = new SimpleLongProperty(this, "id", 0l);
	private final StringProperty name = new SimpleStringProperty(this, "name", "");
	private final StringProperty comments = new SimpleStringProperty(this, "comments", "");
	
	public NoteBook()
	{
		
	}
	
	public NoteBook(Long id, String name, String comments)
	{
		this.id.set(id);
		this.name.set(name);
		this.comments.set(comments);
	}
	
	public LongProperty getId() {
		return id;
	}
	public void setId(Long id) {
		this.id.set(id);
	}
	
	public String getName()
	{
		return this.name.get();
	}
	public StringProperty getNameProperty() {
		return this.name;
	}
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getComments()
	{
		return this.comments.get();
	}
	
	public StringProperty getCommentsProperty() {
		return this.comments;
	}
	public void setComments(String comments) {
		this.comments.set(comments);
	}

}
