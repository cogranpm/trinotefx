package com.glensoft.trinote;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoteHeader {
	
	private final LongProperty id = new SimpleLongProperty(this, "id", 0l);
	private final LongProperty noteBookId = new SimpleLongProperty(this, "noteBookId", 0l);
	private final StringProperty name = new SimpleStringProperty(this, "name", "");
	private final StringProperty comments = new SimpleStringProperty(this, "comments", "");	
	
	public NoteHeader()
	{
		
	}
	
	public NoteHeader(Long id, Long notebookid, String name, String comments)
	{
		this.id.set(id);
		this.noteBookId.set(notebookid);
		this.name.set(name);
		this.comments.set(comments);
	}

	public final LongProperty getId() {
		return id;
	}

	public final void setId(Long id) {
		this.id.set(id);
	}

	public final LongProperty getNoteBookId() {
		return noteBookId;
	}

	public final void setNoteBookId(Long noteBookId) {
		this.noteBookId.set(noteBookId);
	}

	public final StringProperty getName() {
		return name;
	}

	public final void setName(String name) {
		this.name.set(name);
	}

	public final StringProperty getComments() {
		return comments;
	}

	public final void setComments(String comments) {
		this.comments.set(comments);
	}
	
	

}
