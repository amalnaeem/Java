
//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;

public class JDBC {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
	   Class.forName("com.mysql.jdbc.Driver").newInstance();
	   conn = DriverManager.getConnection("jdbc:mysql://localhost/university", "root","");

	   Statement st = conn.createStatement();
	   st.executeQuery("select * from student");
	   ResultSet rs = st.getResultSet();
	   Scanner input =new Scanner(System.in);
	   while(rs.next())
	   {
		   System.out.println(rs.getInt("ID"));
	               System.out.println(rs.getInt("Reg#"));
	               System.out.println(rs.getString("Name"));
	               System.out.println(rs.getString("Class"));
	               System.out.println(rs.getString("Section"));
	               System.out.println(rs.getInt("Contact"));
	               System.out.println(rs.getString("Address"));
	            
	           }
	   System.out.println("Enter name you want to delete");
	   String name = input.next();
	   String SQL = "DELETE FROM student WHERE Name = '"+name+"' ";
	   st.executeUpdate(SQL);
	   // rs = st.getResultSet();
	   
	   System.out.println("Record is deleted!");
	   
	   System.out.println("Enter name you want to search data about");
		String search = input.next();
		 st.executeQuery("select * from student where Name = '"+search+"' ");
		   rs = st.getResultSet();
		   while(rs.next())
		   {
			   System.out.println(rs.getInt("ID"));
		               System.out.println(rs.getInt("Reg#"));
		               System.out.println(rs.getString("Name"));
		               System.out.println(rs.getString("Class"));
		               System.out.println(rs.getString("Section"));
		               System.out.println(rs.getInt("Contact"));
		               System.out.println(rs.getString("Address"));
		             
		           }
	   
	   
	   
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
