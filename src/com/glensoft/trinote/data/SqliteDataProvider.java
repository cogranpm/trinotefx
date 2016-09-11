package com.glensoft.trinote.data;

import java.util.ArrayList;
import java.util.List;

import com.glensoft.trinote.EntityMapper;
import com.glensoft.trinote.NoteBook;
import com.glensoft.trinote.NoteDetail;
import com.glensoft.trinote.NoteHeader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteDataProvider {
	
	private Connection connection = null;
	
	public SqliteDataProvider()
	{
		
	}
	
	public void Connect()
	{
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/paulm/Documents/StudyManager/StudyManager.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Disconnect()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<NoteBook> getNotebooks()
	{
		List<NoteBook> list = null;
		try (Statement statement = connection.createStatement()){
			try(ResultSet rs = statement.executeQuery("select id, name, comments from notebook order by name")){
				list = EntityMapper.MapNoteBook(rs);				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<NoteHeader> getNoteheaders(Long notebookid)
	{
		List<NoteHeader> list = null;
		try (PreparedStatement statement = connection.prepareStatement("select id, notebookid, name, comments from noteheader where notebookid = ? order by name")){
			statement.setLong(1, notebookid);
			try(ResultSet rs = statement.executeQuery()){
				list = EntityMapper.MapNoteHeader(rs);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<NoteDetail> getNotedetails(Long noteheaderid)
	{
		List<NoteDetail> list = null;
		try (PreparedStatement statement = connection.prepareStatement("select id, noteheaderid, name, comments, body, sourcecode from notedetail where noteheaderid = ? order by name")){
			statement.setLong(1, noteheaderid);
			try(ResultSet rs = statement.executeQuery()){
				list = EntityMapper.MapNoteDetail(rs);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	

	
	public void postNoteheader(NoteHeader noteHeader)
	{
		try(PreparedStatement statement = connection.prepareStatement("update notedheader set name = ?, comments = ? where id = ?"))
		{
			statement.setString(1, noteHeader.getName());
			statement.setString(3, noteHeader.getComments());
			statement.setLong(5, noteHeader.getId());
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

	public void putNoteheader(NoteHeader noteHeader)
	{
		try(PreparedStatement statement = connection.prepareStatement("insert into noteheader(NoteBookId, Name, Comments) values (?, ?, ?)"))
		{
			statement.setLong(1, noteHeader.getNoteBookId());
			statement.setString(2, noteHeader.getName());
			statement.setString(4, noteHeader.getComments());
			
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void postNotebook(NoteBook noteBook)
	{
		try(PreparedStatement statement = connection.prepareStatement("update notebook set name = ?, comments = ? where id = ?"))
		{
			statement.setString(1, noteBook.getName());
			statement.setString(2, noteBook.getComments());
			statement.setLong(3, noteBook.getId());
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

	public void putNotebook(NoteBook noteBook)
	{
		try(PreparedStatement statement = connection.prepareStatement("insert into notebook(Name, Comments) values (?, ?)"))
		{
			statement.setString(1, noteBook.getName());
			statement.setString(2, noteBook.getComments());
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

	public void putNoteDetail(NoteDetail noteDetail)
	{
		try(PreparedStatement statement = connection.prepareStatement("insert into notedetail (NoteHeaderId, Name, Comments, Body, SourceCode) values (?, ?, ?, ?, ?)"))
		{
			statement.setLong(1, noteDetail.getNoteHeaderId());
			statement.setString(2, noteDetail.getName());
			statement.setString(3, noteDetail.getSourceCode());
			statement.setString(4, noteDetail.getComments());
			statement.setString(5, noteDetail.getBody());
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}	
	
	
	public void postNoteDetail(NoteDetail noteDetail)
	{
		try(PreparedStatement statement = connection.prepareStatement("update notedetail set name = ?, sourcecode = ?, comments = ?, body = ? where id = ?"))
		{
			statement.setString(1, noteDetail.getName());
			statement.setString(2, noteDetail.getSourceCode());
			statement.setString(3, noteDetail.getComments());
			statement.setString(4, noteDetail.getBody());
			statement.setLong(5, noteDetail.getId());
			statement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	

}
