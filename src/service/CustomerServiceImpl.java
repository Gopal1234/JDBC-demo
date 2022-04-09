package service;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;


public class CustomerServiceImpl {

	Customer customer;

	public int addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		int status = 0;
		try {
			Connection con =  Utility.CustomerUtility.getConnect();
			PreparedStatement ps = con.prepareStatement("insert into Customer values(?,?,?,?,?,?,?)");
			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getCustomerEmail());
			ps.setString(4, customer.getCustomerAddress());
			ps.setLong(5, customer.getCustomerPhone());
			ps.setString(6, customer.getCustomerCity());
			ps.setDate(7, customer.getCustomerDob());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Problem in insertion " + " " + e);
		}
		return status;

	}

	public List<Customer> getCustomer() throws ClassNotFoundException, SQLException {
		
		//List<Customer>customer=new ArrayList<Customer>();
		Connection con = Utility.CustomerUtility.getConnect();
		PreparedStatement ps = con.prepareStatement("select *from Customer");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int custid = rs.getInt(1);
			String custName = rs.getString(2);
			String custEmail = rs.getString(3);
			String custAddress = rs.getString(4);
			long custPhone = rs.getLong(5);
			String custCity = rs.getString(6);
			Date custDate = rs.getDate(7);

			System.out.println(custid + " " + custName + " " + custEmail + " " + custAddress + " " + custPhone + " "
					+ custCity + " " + custDate);

//			Customer c=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getDate(7));
//			customer.add(c);
		}
		return null;

	}

	public Customer getCustomerById(int id) {
		
		
		
		return null;

	}

	public List<Customer> getCustomerBasedOnCity(String city) {
		return null;

	}

	public int updateCustomer(int customerId) {
		return customerId;

	}

	public int deleteCustomer(int customerId) {
		return customerId;

	}
}