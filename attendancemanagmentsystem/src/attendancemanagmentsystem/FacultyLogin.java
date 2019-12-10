package attendancemanagmentsystem;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class FacultyLogin {

	public void Faculty()throws ClassNotFoundException,SQLException {
		// TODO Auto-generated method stub
		java.sql.Connection con=null;//con is an object
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
		
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int ch,f=0,flag=0,count=0;
		System.out.println("Enter the Username");
		String username=s.next();
		System.out.println("Enter the Password");
		String password=s.next();
		Statement s2=(Statement) con.createStatement();
		ResultSet rr=s2.executeQuery("select * from facultylogin");
		while(rr.next())
		{
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
			{
				f=1;
			}
		}
		if(f==1)
			
		{
			System.out.println("Successfully verified");
			do {
				System.out.println("Enter the Choice:\n1.View Student\n2.Add Attendance\n3.Logout");
				 ch=s.nextInt();
				 switch(ch)
				 {
				 case 1:
					 Statement s1=(Statement) con.createStatement();
					ResultSet r=s1.executeQuery("select * from studentdetails");
					System.out.println("List of Students");
					while(r.next())
						{
						
						System.out.println("######*****######");
						System.out.println("ROLL NO ->"+r.getInt(1)+"\n"+"Name ->"+r.getString(2));
						System.out.println("######*****######");
					}
				 break;
				 case 2:
					 
						//student register details
						Statement smt2=con.createStatement();
						ResultSet rs1=smt2.executeQuery("Select * from register");
		
						while(rs1.next())
						{
							System.out.println("rollno---->"+rs1.getInt(1)+"\n"+"name--->"+rs1.getString(2)+"\n"+"date-->"+rs1.getDate(3)+"\n"+"present_absent-->"+rs1.getString(4));
						
						System.out.println("##********************************##");
						
						System.out.println("Enter the Roll_no:");
						}
						int id=s.nextInt();
						//check the rollno
						
							
							LocalDate d=LocalDate.now();
							String date1=d.toString();
							//LocalDate date1=date;
							System.out.println("Todays Date:");
							System.out.println(date1);
							System.out.println("Enter Present/Absent(P/A):");
							String pa=s.next();
							String c=pa.toUpperCase();
							int i=0;
							if(c.equals("P"))
							{
								i++;
							}
							else
							{
								i=0;
							}
							/*int cnt=0,present=0;
							if(rs1.getInt(1)==id&&c.equals("P"))
						{
								cnt++;
								present=cnt;
							}*/
							System.out.println("Enter Student name:");
							String name=s.next();
							int td=30;
							double per1=i/td;
							double per2=per1*100;
							PreparedStatement st=con.prepareStatement("Insert into register(rollno,name,date,present_absent) values(?,?,?,?);");
			                st.setInt(1,id);
							st.setString(2,name);
							st.setString(3,date1);
							st.setString(4,pa);
							//st.setInt(5,i);
							
							
							st.executeUpdate();
						
						System.out.println("Added Today's Attendance");
						/*int total=30;
						float p=(total/30)*100;
						//System.out.println(present);
						PreparedStatement st1=con.prepareStatement("Insert into viewregister(rollno,name,total,percentage) values(?,?,?,?);");
		                st1.setInt(1,id);
						st1.setString(2,name);
						st1.setInt(3,total);
						st.setFloat(4,p);
						st.executeUpdate();
						//st.setInt(5,i);*/
						
						
						break;
				 case 3:
					 System.out.println("Faculty logged out successfully!!");
					 return;
				 }
				 
			}while(ch!=0);
		}
		else
		{
			System.out.println("Sorry!!");
			System.out.println("Incorrect Username and Password");
		}
	}

}
