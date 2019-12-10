package attendancemanagmentsystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentLogin {

	public void Student() throws SQLException {
		java.sql.Connection con=null;//Connection object
		//2)create a Connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the user name");
		String username=s.next();
		System.out.println("Enter the password");
		String password=s.next();
		
		Statement smt=con.createStatement();
		ResultSet rr=smt.executeQuery("Select * from studentlogin");
		int f=0;int m;
		while(rr.next())
		{
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
			{
				f=1;
			}
		}
		if(f==1)	
		{
			System.out.println("Sucessfully verified");
			do {
				System.out.println("1.Student Details\n2.Attendence\n3.Logout");
				System.out.println("Enter the choice");
				m=s.nextInt();	
				switch(m)
				{
				case 1:
					Statement smt1=con.createStatement();
					ResultSet rs=smt1.executeQuery("Select * from studentdetails");
					//System.out.println("rollno"+"\t"+"name"+"\t"+"address"+"\t"+"department"+"\t"+"mobile");
					while(rs.next())
					{
						System.out.println("######************######");
						System.out.println("rollno---->"+rs.getInt(1)+"\n"+"name--->"+rs.getString(2)+"\n"+"address-->"+rs.getString(3)+"\n"+"department-->"+rs.getString(4)+"\n"+"mobile-->"+rs.getInt(5));
					}
					
					break;
				case 2:
					Statement smt2=con.createStatement();
					ResultSet rs1=smt2.executeQuery("Select * from register");
					
					
					//System.out.println("rollno"+"\t"+"name"+"\t"+"date"+"\t"+"present_absent");
					System.out.println("Students Attendance Details");
					//System.out.println("######************######");
					while(rs1.next())
					{System.out.println("######************######");
						System.out.println("rollno---->"+rs1.getInt(1)+"\n"+"name--->"+rs1.getString(2)+"\n"+"date-->"+rs1.getDate(3)+"\n"+"present_absent-->"+rs1.getString(4));
					}
					
					break;
				case 3:
					System.out.println("Student logged out successfully!!");
				  return;
				  
				}
				}while(m!=0);
			
			
		}
		else
		{
			System.out.println("Incorrect password or username");
		}
	}

}

