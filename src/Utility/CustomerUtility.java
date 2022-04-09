package Utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class CustomerUtility {

	public static Connection getConnect()
	{
		Connection connection=null;
		try
		{
		Class.forName("org.postgresql.Driver");
		
		/*
		 * Designer Developer  DataBase Team Testers
		 * 
		 *                       json
		 *                       xml
		 *                       text
		 *                       properties
		 * 
		 * 
		 */
		//getConnect()throws SQLExcepton
	 connection=  DriverManager.getConnection("jdbc:postgresql://localhost:5432/Cloud18BatchDB", "postgres", "root");
		System.out.println(connection)	;	

		}catch(Exception e)
		{
			System.out.println("Problem in connection");
		}
		
		return connection;
	}
	
	
}
