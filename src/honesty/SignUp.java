
package honesty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SignUp {
    User obj1=new User();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    

   Scanner in=new Scanner(System.in);
   
       private Connection connect() {
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
       
    
 }
   public void save_info() throws IOException 
 {
        
        obj1.UserID=getIDAndSaveID();
        String Query = "INSERT INTO userinfo(username,password,email ,phone ,id ) VALUES(?,?,?,?,?)";
   
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
 }
   public int getIDAndSaveID() throws IOException
   {
       int id=0;
       ////////////////////////* get from file *////////////////////////////////
        try    
                    {
                        String pointer="";
                        File fileName =new File("ID.txt");
                        FileReader fileReader =  new FileReader(fileName);
                        BufferedReader bufferedReader =  new BufferedReader(fileReader);
                        while((pointer = bufferedReader.readLine()) != null)
                        {  
                            id = Integer.parseInt(pointer); 
                            //System.out.println("POinter "+pointer );
                        }
                    }
                catch (Exception ex)
                      {
                        System.out.println("*-*Error Message");
                      }
       
       ////////////////////////* put from file *////////////////////////////////
          id++;
        try    
               {
                   FileWriter FOut =new FileWriter("ID.txt");
                 
                       String COMPRESSION=""+(id);
                       FOut.write(COMPRESSION);
                       FOut.write("\n");  
                       FOut.close();
               }
               catch (Exception ex)
               {
                   System.out.println("Error Message");
               }
       return id;
   }
    
}
