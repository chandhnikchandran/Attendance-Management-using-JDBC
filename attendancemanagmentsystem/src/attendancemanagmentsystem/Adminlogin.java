package attendancemanagmentsystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Adminlogin {

	public void Admin() throws SQLException,ClassNotFoundException {
		java.sql.Connection con=null;//Connection object
		//2)create a Connection
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
		Scanner s= new Scanner(System.in);
		int m;
		System.out.println("Enter Your Username:");
		String username=s.next();
		System.out.println("Enter your password:");
		String password=s.next();
		Statement smt=(Statement) con.createStatement();
		ResultSet rr=smt.executeQuery("Select * from admin");
		// TODO Auto-generated method stub
		while(rr.next())
		{
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
		   {
				f=1;
		    }
		}
		if(f==1)
		{
		System.out.println("Successfully verified!");
		do
		{
			System.out.println("1.Add Faculty\n2.Add Student\n3.Display\n4.Update\n5.Remove\n6.Logout");
			System.out.println("Enter the choice:");
			m=s.nextInt();
			
		
		switch(m)
		{
		case 1:
			System.out.println("Enter Faculty Id:");
			int fid=s.nextInt();
			System.out.println("Enter Faculty Name:");
			String fname=s.next();
			System.out.println("Enter Depatment:");
			String fdep=s.next();
			System.out.println("Enter Mobile:");
			int mobile=s.nextInt();
			PreparedStatement ps=con.prepareStatement("insert into facultydetails(id,name,department,mobile)values(?,?,?,?);");
			//PreparedStatement ps1=con.prepareStatement("insert into facultylogin(name,mobile)values(?,?);");
			ps.setInt(1,fid);//
			ps.setString(2,fname);
			ps.setString(3,fdep);
			ps.setDouble(4,mobile);
			ps.executeUpdate();
			//ps1.setString(1,fname);
			//ps1.setDouble(4,mobile);
			//ps1.executeUpdate();
			System.out.println("One Faculty Inserted..!");
			break;
		case 2:
			System.out.println("Enter Student Rollno:");
			int rollno=s.nextInt();
			System.out.println("Enter Student Name:");
			String sname=s.next();
			System.out.println("Enter Address:");
			String address=s.next();
			System.out.println("Enter Department:");
			String dep=s.next();
			System.out.println("Enter Mobile:");
			int mob=s.nextInt();
			PreparedStatement st=con.prepareStatement("insert into studentdetails(rollno,name,address,department,mobile)values(?,?,?,?,?);");
			//PreparedStatement st1=con.prepareStatement("insert into studentlogin(name,mobile)values(?,?);");
			st.setInt(1,rollno);//
			st.setString(2,sname);
			st.setString(3,address);
			st.setString(4,dep);
			st.setInt(5,mob);
			st.executeUpdate();
			
			//st1.setString(1,sname);
			//st1.setInt(2,mob);
			//st1.executeUpdate();
			System.out.println("One Student Inserted..!");
			break;
		case 3:
			System.out.println("Display Details:");
			System.out.println("1.Faculty Details\n2.Student Details");
			System.out.println("Enter your Choice?:");
			int x=s.nextInt();
			switch(x)
			{
			case 1:
				Statement smt1=(Statement) con.createStatement();
				ResultSet rs=smt1.executeQuery("Select * from facultydetails");
				System.out.println("Faculty Details:");
				System.out.println("###########***********#############");
				while(rs.next())
				{
					System.out.println("Faculty Id ->"+rs.getInt(1)+"\n"+"Faculty Name ->"+rs.getString(2)+"\n"+"Department ->"+rs.getString(3)+"\n"+"Mobile ->"+rs.getInt(4));
				}
				System.out.println("###########***********#############");
				break;
			case 2:
				Statement smt2=(Statement) con.createStatement();
				ResultSet rs1=smt2.executeQuery("Select * from studentdetails");
				System.out.println("Students Details:");
				System.out.println("###########***********#############");
				while(rs1.next())
				{
					System.out.println("Roll no ->"+rs1.getInt(1)+"\n"+"Name ->"+rs1.getString(2)+"\n"+"Address ->"+rs1.getString(3)+"\n"+"Department ->"+rs1.getString(4)+"\n"+"Mobile ->"+rs1.getInt(5));
				}
				System.out.println("###########***********#############");
				break;
			default :
				System.out.println("Invalid Entry");	
			}
			break;
		case 4:
			System.out.println("Update Details:");
			System.out.println("1.Faculty Details\n2.Student Details");
			System.out.println("Enter your Choice?:");
			int y=s.nextInt();
			switch(y)
			{
			case 1://faculty details..
				Statement smt1=(Statement) con.createStatement();
				ResultSet rs=smt1.executeQuery("Select * from facultydetails");
				System.out.println("Faculty Details:");
				System.out.println("###########***********#############");
				while(rs.next())
				{
					System.out.println("Faculty Id ->"+rs.getInt(1)+"\n"+"Faculty Name ->"+rs.getString(2)+"\n"+"Department ->"+rs.getString(3)+"\n"+"Mobile ->"+rs.getInt(4));
				}
				System.out.println("###########***********#############");
				//update query
				System.out.println("Enter Faculty Id:");
				int id=s.nextInt();
				System.out.println("Enter new Faculty Name:");
				String namef=s.next();
				System.out.println("Enter Deprtment:");
				String depf=s.next();
				System.out.println("Enter new mobile:");
				int fmob=s.nextInt();
				Statement smt4=(Statement) con.createStatement();
				ResultSet rs4=smt4.executeQuery("Select * from facultydetails");
				
				while(rs4.next())
				{    
					int idd = rs4.getInt(1);
					if(idd==id)
					{
					PreparedStatement pss=con.prepareStatement("update facultydetails set name=?,department=?,mobile=? where id=?");
					pss.setString(1,namef);
					pss.setString(2,depf);
					pss.setInt(3,fmob);
					pss.setInt(4,id);
					pss.executeUpdate();
					System.out.println("Successfully Updated...");
					}
					
				}
				
					
				
				break;
			case 2:
				Statement smt2=(Statement) con.createStatement();
				ResultSet rs1=smt2.executeQuery("Select * from studentdetails");
				System.out.println("Students Details:");
				System.out.println("###########***********#############");
				while(rs1.next())
				{
					System.out.println("Roll no ->"+rs1.getInt(1)+"\n"+"Name ->"+rs1.getString(2)+"\n"+"Address ->"+rs1.getString(3)+"\n"+"Department ->"+rs1.getString(4)+"\n"+"Mobile ->"+rs1.getInt(5));
				}
				System.out.println("###########***********#############");
				
				//update query
				System.out.println("Enter Student Rollno:");
				int rolno=s.nextInt();
				System.out.println("Enter new Student Name:");
				String names=s.next();
				System.out.println("Enter new Address:");
				String add=s.next();
				System.out.println("Enter Deprtment:");
				String deps=s.next();
				System.out.println("Enter new mobile:");
				int smob=s.nextInt();
				Statement smt5=(Statement) con.createStatement();
				ResultSet rs5=smt5.executeQuery("Select * from facultydetails");
				
				while(rs5.next())
				{    
					int idd = rs5.getInt(1);
					if(idd==rolno)
					{
					PreparedStatement pss=con.prepareStatement("update studentdetails set name=?,address=?,department=?,mobile=? where rollno=?");
					pss.setString(1,names);
					pss.setString(2,add);
					pss.setString(3,deps);
					pss.setInt(4,smob);
					pss.setInt(5,rolno);
					pss.executeUpdate();
					System.out.println("Successfully Updated...");
					}
					
				}
				break;
			default :
				System.out.println("Invalid Entry");	
			}
			break;
				
			
			case 5:
				System.out.println("1.Faculty Details\n2.Student Details");
				System.out.println("Enter your Choice?:");
				int z=s.nextInt();
				switch(z)
				{
				case 1://faculty details..
					Statement sm1=(Statement) con.createStatement();
					ResultSet r1=sm1.executeQuery("Select * from facultydetails");
					System.out.println("Faculty Details:");
					System.out.println("###########***********#############");
					while(r1.next())
					{
						System.out.println("Faculty Id ->"+r1.getInt(1)+"\n"+"Faculty Name ->"+r1.getString(2)+"\n"+"Department ->"+r1.getString(3)+"\n"+"Mobile ->"+r1.getInt(4));
					}
					System.out.println("###########***********#############");
				
				System.out.println("Enter Faculty id:");
				int idd=s.nextInt();
				PreparedStatement pp=con.prepareStatement("delete from facultydetails where id=?;");
				pp.setInt(1,idd);
				pp.executeUpdate();
				System.out.println("Successfully Removed...");
				break;
				case 2:
					Statement sm2=(Statement) con.createStatement();
					ResultSet r2=sm2.executeQuery("Select * from studentdetails");
					System.out.println("Students Details:");
					System.out.println("###########***********#############");
					while(r2.next())
					{
						System.out.println("Roll no ->"+r2.getInt(1)+"\n"+"Name ->"+r2.getString(2)+"\n"+"Address ->"+r2.getString(3)+"\n"+"Department ->"+r2.getString(4)+"\n"+"Mobile ->"+r2.getInt(5));
					}
					System.out.println("###########***********#############");
					
				
				System.out.println("Enter rollno:");
				int srollno=s.nextInt();
				PreparedStatement p1=con.prepareStatement("delete from studentdetails where rollno=?;");
				p1.setInt(1,srollno);
				p1.executeUpdate();
				System.out.println("Successfully Removed...");
					break;
				
				
			default :
				System.out.println("Invalid Entry");	
			}
			case 6:
				
				return;
				
			
		}	
				
		
		}while(m!=0);
		
		}
		
		
		else
		{
			
			System.out.println("Incorrect username and password");
		}
	}

}
