import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import Utility.CustomerUtility;
import pack1.Employee;

/*
 *  Model class- Data--Bank, Customer 
 *  Java Application
 *  java.sql.*
 *  |
 *  
 *  
 *  
 *  
 *  |
 *  mySql , Orcale
 *  Data Base Server--Postgresql 
 *  
 *  (SQL)
 * 
 * Step1 ---Link the communication between java application and data server.
 * Step2-Introduce driver
 * Step3--DriverManager should be instantited
 * Step4--Connection object is then return
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
/* package          component
 * utility           CustomerUtilty
 * model------------ Customer
 * CustomerDAO---------
 * i) public int addCustomer(Customer customer)
 * 1 or 0
 * ii)public List<Customer> getCustomer();
 * iii) public Customer getCustomerById(int id)
 * iv) public List<Customer> getCustomerBasedOnCity(String city)
 * v)public int updateCustomer(int customerId)
 * vi)public int deleteCustomer(int customerId)
 * 
 * main---
 * 
 * 
 */


public class TestJdbcDemo1 {

	public static void main(String[] args) throws SQLException, ParseException 
	{
	Connection conObj=	CustomerUtility.getConnect();
	System.out.println("Enter Employee information");
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter employee id");
	int id=Integer.parseInt(scanner.nextLine());
	System.out.println("Enter employee name");
	String empName=scanner.nextLine();
		
	System.out.println("Enter employee address");
	String empAddress=scanner.nextLine();
	System.out.println("Enter employee phone");
	long empPhone=Long.parseLong(scanner.nextLine());
	System.out.println("Enter empoyee dob");//
	String dob1=scanner.nextLine();
	DateFormat format1=new SimpleDateFormat("dd/MM/YYYY");
java.util.Date d1=	format1.parse(dob1);
java.sql.Date d2=new java.sql.Date(d1.getTime());

	
	
	//insert the row in relation
	//Statement
	
	//PreparedStatement
	//CallableStatement
	//?1-empId-int
	//?2=empNAme-strring
	///3-empAddress-string
	//?4-empPhone-long
	//insert into employeeinfo values(1, 'anbc'_);
	//""+id+"
	PreparedStatement ps= conObj.prepareStatement("insert into EmployeeInfo values(?,?,?,?)");
	ps.setInt(1,id);
	ps.setString(2, empName);
	ps.setString(3,empAddress);
	ps.setLong(4, empPhone);
	ps.setD
int rowNumber=	ps.executeUpdate();
System.out.println(rowNumber);
 if(rowNumber >0)
 {
	 String sqlQuery1="select * from EmployeeInfo";
	 //ResultSet executeQuery(String sqlQuery)
	 
	 /*
	  *   empid  empName  empAdd  empPhone
	  *  
	  *    2       "B"     "Bang"  345
	  *   1      "A"     "kol"   123
	  * 
	  */
	 PreparedStatement ps1=conObj.prepareStatement(sqlQuery1);
	ResultSet rs=   ps1.executeQuery();
	while(rs.next())
	{
		int empId=rs.getInt(1);
	String empName1=	rs.getString(2);
	 String empAddress1=rs.getString(3)	;
	 long mobileNumber=rs.getLong(4);
	 System.out.println(empId + " "+empName1 + " "+empAddress1 +" "+mobileNumber);
	}
	 
	 
	 
 }

//based on employee id need to fetch information
 System.out.println("Enter employee id to search");
 int empSearchId=Integer.parseInt(scanner.nextLine());
PreparedStatement ps3=	conObj.prepareStatement("select * from EmployeeInfo where empid=? and empphone=? order by empid");
	ps3.setInt(1, empSearchId);	
	ps3.setLong(2, 2242L);
	ResultSet rs2=ps3.executeQuery();
	if(rs2.next())
	{
		int empId=rs2.getInt(1);
	String empName1=	rs2.getString(2);
	 String empAddress1=rs2.getString(3)	;
	 long mobileNumber=rs2.getLong(4);
	 System.out.println(empId + " "+empName1 + " "+empAddress1 +" "+mobileNumber);
		
	}
	
	System.out.println("Enter employee id to update phone");
	 int empUpdateId=Integer.parseInt(scanner.nextLine());
	 System.out.println("Enter employee new phone to update phone");
	 long empUpdatePhone=Long.parseLong(scanner.nextLine());
	 PreparedStatement ps4=	conObj.prepareStatement("update EmployeeInfo set empphone=? where empid=?");
	 ps4.setLong(1, empUpdatePhone);
	 ps4.setInt(2, empUpdateId);
int k=	 ps4.executeUpdate();
if(k>0)
{
	System.out.println("updated");
	
	
}

	}

}
