import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Feedback;
import service.FeedBackDAO;

public class Main {

	public static void main(String[] args) throws ParseException
	{
		FeedBackDAO dao=new FeedBackDAO();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Give your feedback");
		System.out.println("Enter feedback id");
		int id=Integer.parseInt(scanner.nextLine());
		System.out.println("Enter msg");
		String msg=scanner.nextLine();
		System.out.println("Enter date of feedback");
		String inputDate1=scanner.nextLine();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date d1=	format.parse(inputDate1);
	java.sql.Date d2=new java.sql.Date(d1.getTime());
	Feedback feedback=new Feedback();
	feedback.setFeedbackId(id);
	feedback.setMsg(msg);
	feedback.setFeedbackDate(d2);
	int status=dao.addFeedback(feedback);
	System.out.println(status);
		
		
		
		
	}
}
