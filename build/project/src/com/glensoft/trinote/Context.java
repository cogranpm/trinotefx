package com.glensoft.trinote;

import com.glensoft.trinote.data.SqliteDataProvider;

public class Context {
	private final static Context instance = new Context();
	
	public static Context getInstance()
	{
		return instance;
	}
	
	private SqliteDataProvider dataProvider = new SqliteDataProvider();
	public SqliteDataProvider getProvider()
	{
		return dataProvider;
	}
}
