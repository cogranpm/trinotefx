package com.glensoft.trinote;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NoteDetail {
	private final LongProperty id = new SimpleLongProperty(this, "id", 0);
	private final LongProperty noteHeaderId = new SimpleLongProperty(this, "noteHeaderId", 0);
	private  final StringProperty name = new SimpleStringProperty(this, "name", "");
	private  final StringProperty comments = new SimpleStringProperty(this, "comments", "");	
	private  final StringProperty body = new SimpleStringProperty(this, "body", "");
	private  final StringProperty sourceCode = new SimpleStringProperty(this, "sourceCode", "");
	
	public NoteDetail() {
		
	}


	public NoteDetail(Long id, Long noteHeaderId, String name, String comments, String body, String sourceCode) {
		super();
		this.id.set(id);
		this.noteHeaderId.set(noteHeaderId);
		this.name.set(name);
		this.comments.set(comments);
		this.body.set(body);
		this.sourceCode.set(sourceCode);
	}


	public Long getId() {
		return id.get();
	}
	
	public LongProperty idProperty()
	{
		return this.id;
	}


	public void setId(Long id) {
		this.id.set(id);
	}


	public Long getNoteHeaderId() {
		return noteHeaderId.get();
	}
	
	public LongProperty noteHeaderIdProperty()
	{
		return noteHeaderId;
	}


	public void setNoteHeaderId(Long noteHeaderId) {
		this.noteHeaderId.set(noteHeaderId);
	}


	public String getName() {
		return name.get();
	}

	public StringProperty nameProperty()
	{
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}


	public String getComments() {
		return comments.get();
	}
	
	public StringProperty commentsProperty()
	{
		return this.comments;
	}


	public void setComments(String comments) {
		this.comments.set(comments);
	}


	public String getBody() {
		return body.get();
	}

	public StringProperty bodyProperty()
	{
		return this.body;
	}

	public void setBody(String body) {
		this.body.set(body);
	}


	public String getSourceCode() {
		return sourceCode.get();
	}
	
	public StringProperty sourceCodeProperty()
	{
		return this.sourceCode;
	}


	public void setSourceCode(String sourceCode) {
		this.sourceCode.set(sourceCode);
	}
	
	
	
	

}
