
package honesty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SignUp {
    User obj1=new User();
    User obj2=new User();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    
//    app_user obj=new app_user() ;
    String input , input1;
   Scanner in=new Scanner(System.in);
   
       private Connection connect() {
        // SQLite connection string
        String url = "jdbc:mysql://localhost/SW?user=root";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
   public SignUp()
    {
     try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/SW?user=root");
            //Don't forget the db name
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   public void signup()
 {
      
     System.out.println("***********SIGN UP**************");
     System.out.println("Enter user name :");
     Scanner ob=new Scanner(System.in);
     obj1.UserName=ob.nextLine();
     System.out.println("Enter E-mail :");
     Scanner ob1=new Scanner(System.in);
     obj1.UserEmail=ob1.nextLine();
     System.out.println("Enter Password :");
     Scanner ob2=new Scanner(System.in);
      obj1.UserPassword=ob2.nextLine();
      System.out.println("Enter Phone :");
      Scanner ob3=new Scanner(System.in);
      obj1.UserPhone=ob3.nextInt();
         System.out.println("Enter user name :");
     Scanner ob0=new Scanner(System.in);
     obj2.UserName=ob0.nextLine();
     System.out.println("Enter E-mail :");
     Scanner ob11=new Scanner(System.in);
     obj2.UserEmail=ob11.nextLine();
     System.out.println("Enter Password :");
     Scanner ob22=new Scanner(System.in);
      obj2.UserPassword=ob22.nextLine();
      System.out.println("Enter Phone :");
      Scanner ob33=new Scanner(System.in);
      obj2.UserPhone=ob33.nextInt();
    
 }
   public void save_info() 
 {
     
        String Query = "INSERT INTO userinfo(username,password,email ,phone ,id ) VALUES(?,?,?,?,?)";
        String Queryy = "INSERT INTO userinfo(username,password,email ,phone ,id ) VALUES(?,?,?,?,?)";
   
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(Query)) {
            pstmt.setString(1, obj1.UserName);
            pstmt.setString(2, obj1.UserPassword);
            pstmt.setString(3, obj1.UserEmail);
            pstmt.setInt(4, obj1.UserPhone);
            pstmt.setInt(5, obj1.UserID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(Query)) {
            pstmt.setString(1, obj2.UserName);
            pstmt.setString(2, obj2.UserPassword);
            pstmt.setString(3, obj2.UserEmail);
            pstmt.setInt(4, obj2.UserPhone);
            pstmt.setInt(5, obj2.UserID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 }
    
}
