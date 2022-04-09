package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utility.CustomerUtility;
import model.Feedback;

public class FeedBackDAO {
	
	//This method will first estabilish the connection with database by calling getConnect()
	//method
	//feedback=new FeedBack()
	//feedback.setId(10)
	//feedback.setMas("Hi");
	//feedbacl.setDate("2022-
	public int addFeedback(Feedback feedback)
	{
		int status=0;
		try
		{
	Connection con=	 CustomerUtility.getConnect();
		PreparedStatement ps=con.prepareStatement("insert into Feedback values(?,?,?)");
		ps.setInt(1, feedback.getFeedbackId());
		ps.setString(2, feedback.getMsg());
		ps.setDate(3, feedback.getFeedbackDate());
		//int executeUpdate()insert/delete/update
	status=	ps.executeUpdate();

		
		}
		catch(Exception e)
		{
			System.out.println("problem in insertion" + " "+e);
		}
		
		
		
		return status;
		
	}
	
	public List<Feedback> getFeedback() throws SQLException
	{
		
		List<Feedback> listOfFeedback=new ArrayList<Feedback>();
		Connection con=CustomerUtility.getConnect();
		
	PreparedStatement ps1=	con.prepareStatement("select * from Feedback where feedbackid=? ");
	ps1.setInt(1, id);
	ResultSet rs=ps1.executeQuery();
		
	while(rs.next())
	{
		int id=rs.getInt(1);
		String msg=rs.getString(2);
		java.sql.Date df=rs.getDate(3);
		
		Feedback feedback=new Feedback();
		feedback.setFeedbackId(id);
		feedback.setMsg(msg);
		feedback.setFeedbackDate(df);
		listOfFeedback.add(feedback);
		
		
		
	}
	return listOfFeedback;
	}

}
