import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import Utility.*;

import model.Customer;
import service.CustomerServiceImpl;


public class CustomerMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		
		
		CustomerServiceImpl service=new CustomerServiceImpl();
		System.out.println("Enter Customer information");
		System.out.println("**********");
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter customerId");
		int customerId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter customerName");
		String customerName = scanner.nextLine();

		System.out.println("Enter customerEmail");
		String customerEmail=scanner.nextLine();
		
		System.out.println("Enter customerAddress");
		String customerAddress = scanner.nextLine();
		
		System.out.println("Enter customerPhone");
		long customerPhone = Long.parseLong(scanner.nextLine());
		
		System.out.println("Enter customerCity");
		String customerCity=scanner.nextLine();
		
		
		System.out.println("Enter customerDob");
		String customerDob=scanner.nextLine();
		DateFormat format=new SimpleDateFormat("dd/mm/yyyy");
		java.util.Date d=format.parse(customerDob);
		java.sql.Date d1=new java.sql.Date(d.getTime());
		
		
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setCustomerEmail(customerEmail);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerPhone(customerPhone);
		customer.setCustomerCity(customerCity);
		customer.setCustomerDob(d1);
		
		int status=service.addCustomer(customer);
		System.out.println(status);

		service.getCustomer();
		service.getCustomerById(customerId);
		
	}

}