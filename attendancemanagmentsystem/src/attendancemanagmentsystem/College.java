package attendancemanagmentsystem;

import java.sql.SQLException;
import java.util.Scanner;


public class College {
	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		int n;
		Scanner s=new Scanner(System.in);
		do{
		System.out.println("1.Admin Login\n2.Faculty Login\n3.Student Login\n4.Exit");
		System.out.println("Enter the choice:");
		n=s.nextInt();
		switch(n)
		{
		case 1:
			Adminlogin obj1=new Adminlogin();
			obj1.Admin();
			break;
		case 2:
			FacultyLogin obj2=new FacultyLogin();
			obj2.Faculty();
			break;
		case 3:
			StudentLogin obj3=new StudentLogin();
			obj3.Student();
			break;
		case 4:
			System.out.println("Successfully Logout...!");
			return;
		}
			
		}while(n!=0);
	}
		
	}

