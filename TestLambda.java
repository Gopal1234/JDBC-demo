package lambdademos;

import servicepack.CustomerService;

/*
 * 
 * What is lambda expression
 * why we use lambda expression
 * 1.it reduce the coding length
 * 
 * 
 */

/*class A implements CustomerService
{

	@Override
	public boolean login(String userName, String password) {
		if(userName.equalsIgnoreCase("admin") && password.equals("123"))
		{
			return true;
		}
		return false;
	}
	
}*/

public class TestLambda {

	public static void main(String[] args) {

 /*  CustomerService service=new CustomerService() {

	@Override
	public boolean login(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}
};*/
		//no need write method
	CustomerService service=	 (name, pass)->{if(name.equalsIgnoreCase("admin")&& pass.equals("123"))
		
	{
		return true;
	}
	return false;
	
	};
	boolean b=	service.login("admin", "123");
	if(b)
	{
		System.out.println("you are valid admin");
		
	}else
	{
		System.out.println("Invalid admin");
	}
		
		
	}

}
